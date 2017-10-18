package com.mooveit.library

import com.mooveit.library.providers.*
import com.mooveit.library.providers.definition.*
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class Fakeit private constructor(locale: Locale) {

    private val yaml = Yaml()
    private val fakeValues: LinkedHashMap<String, LinkedHashMap<String, String>>
    private val fakeValuesDefaults: LinkedHashMap<String, LinkedHashMap<String, String>>

    var uniqueValueActive = false

    init {
        val stringLocale = if (locale.country.isEmpty()) {
            locale.language
        } else {
            locale.language.plus(locale.country.toLowerCase())
        }

        fakeValues = yaml.getValues(stringLocale, javaClass)
        fakeValuesDefaults = if (stringLocale != defaultLanguage) {
            yaml.getValues(defaultLanguage, javaClass)
        } else {
            LinkedHashMap()
        }
    }

    /***
     * Initial method to call
     *
     * @param key String for search Example: "address.secondary_address"
     *
     * @return String
     ***/
    fun fetch(key: String): String {
        val separator = key.lastIndexOf(".")
        val category = key.substring(0, separator)
        val selected = key.substring(separator + 1, key.length)
        val selectedValue = fetchSelectedValue(key, category, selected)

        val matchBraces = Pattern.compile(numeralAndBracesRegEx).matcher(selectedValue)
        val matchNumeric = Pattern.compile(numeralRegEx).matcher(selectedValue)
        return when {
            matchBraces.find() -> fetchKeyValueData(category, selectedValue)
            matchNumeric.find() -> fetchNumerals(selectedValue)
            else -> selectedValue
        }
    }

    /***
     * Get random string result from the values map
     *
     * @param key String for search Example: "address.secondary_address"
     * @param category String the key for the map to return Example: "address"
     * @param selected String the key for the map returned Example: "secondary_address"
     *
     * @return String
     ***/
    private fun fetchSelectedValue(key: String, category: String, selected: String): String {
        var categoryValues = fetchCategory(key, category, true, fakeValues)
        if (categoryValues[selected] == null) {
            if (fakeValuesDefaults.size == 0) {
                throw Exception(getResourceNotFound(key))
            }
            categoryValues = fetchCategory(key, category, false, fakeValuesDefaults)
            if (categoryValues[selected] == null) {
                throw Exception(getResourceNotFound(key))
            }
        }
        when {
            categoryValues[selected] is ArrayList<*> -> {
                val values = categoryValues[selected] as ArrayList<ArrayList<String>>
                if (values[0] is CharSequence) {
                    return (values as ArrayList<String>).getRandomString()
                }
                return values[Random().nextInt(values.size)].getRandomString()
            }
            categoryValues[selected] is String -> return categoryValues[selected] as String
            else -> throw Exception("Resource $category.$selected is not a value")
        }
    }

    /***
     * Get the map that holds the selected value as key Example: key: "address.secondary_address" selected: "secondary_address"
     * It call getCategoryAndValues(...) to return the correct values map if needed instead of valuesToFetch
     *
     * @param key String for search Example: "address.secondary_address"
     * @param category String the key for the map  Example: "address"
     * @param check Boolean true if needed to check on default params
     * @param valuesToFetch LinkedHashMap<String, LinkedHashMap<String, String>> the initial map to fetch the category
     *
     * @return LinkedHashMap<*, *>
     ***/
    private fun fetchCategory(key: String, category: String, check: Boolean,
                              valuesToFetch: LinkedHashMap<String, LinkedHashMap<String, String>>): LinkedHashMap<*, *> {
        val (_, subCategory, _, values) = getCategoryAndValues(key, Params(category.indexOf("."), category, check, valuesToFetch))
        return when {
            values[subCategory] is LinkedHashMap<*, *> -> values[subCategory] as LinkedHashMap<*, *>
            values[subCategory] is ArrayList<*> -> {
                val valuesList = values[subCategory] as ArrayList<LinkedHashMap<*, *>>
                valuesList[Random().nextInt(valuesList.size)]
            }
            else -> throw Exception("Resource Key not found $category on $key")
        }
    }

    /***
     * Get the param holder needed for the key.
     * If the values for the language does not have the category it will set the params to the defaults.
     * It search until the end of the map if needed.
     *
     * @param key string for search Example: "address.secondary_address"
     * @param baseParams Params the initial value holder for search
     *
     * @return Params
     ***/
    private fun getCategoryAndValues(key: String, baseParams: Params): Params {
        val p = Params(baseParams.separator, baseParams.category, baseParams.check, baseParams.values)

        if (p.separator == -1 && p.values[p.category] == null) {
            checkAndSetParams(key, baseParams, p)
        }

        while (p.separator != -1) {
            if (p.check && p.values[p.category.substring(0, p.separator)] == null) {
                checkAndSetParams(key, baseParams, p)
            }
            p.values = p.values[p.category.substring(0, p.separator)] as LinkedHashMap<String, LinkedHashMap<String, String>>
            p.category = p.category.substring(p.separator + 1, p.category.length)
            p.separator = p.category.indexOf(".")
            if (p.separator == -1 && p.values[p.category] == null) {
                checkAndSetParams(key, baseParams, p)
            }
        }
        return p
    }

    /***
     * Method that reset the param for search with the defaults and initial param
     *
     * @param key String for search Example: "address.secondary_address"
     * @param baseParams Params the initial value holder for search
     * @param params Params new value holder for search
     ***/
    private fun checkAndSetParams(key: String, baseParams: Params, params: Params) {
        if (!params.check || this.fakeValuesDefaults.size == 0) {
            throw Exception(getResourceNotFound(key))
        }
        params.separator = baseParams.category.indexOf(".")
        params.category = baseParams.category
        params.values = this.fakeValuesDefaults
        params.check = false
    }

    private fun fetchKeyValueData(category: String, selectedValue: String): String {
        val stringBuffer = StringBuffer()
        return matchAndReplace(selectedValue, stringBuffer, numeralAndBracesRegEx, { matcher ->
            matcher.appendReplacement(stringBuffer, fetchValueByCategory(category, matcher.group().replace("#{", "").replace("}", "")))
        })
    }

    /***
     * Initial method for recursive mode Example when the map random string return "#{Name.first_name} #{street_suffix}"
     *
     * @param key String for search Example: "address.secondary_address"
     * @param category String the key for the map to return Example: "address"
     *
     * @return String random from map fetched
     ***/
    private fun fetchValueByCategory(category: String, key: String): String {
        val separator = key.lastIndexOf(".")
        return if (separator == -1) {
            fetch("$category.$key".toLowerCase())
        } else {
            fetch(key.toLowerCase())
        }
    }

    /***
     *  Search params holder class
     *
     *  @param separator Int position of "." char on the key search string
     *  @param category String the key without the las part from last index of "." to end
     *  Example: key: "address.secondary_address" category: "address"
     *
     *  @param check Boolean true if needed to check on default params
     *  @param values LinkedHashMap<String, LinkedHashMap<String, String>> where to search the category
     ***/
    data class Params(var separator: Int, var category: String, var check: Boolean,
                      var values: LinkedHashMap<String, LinkedHashMap<String, String>>)

    companion object Companion {

        var fakeit: Fakeit? = null
        var providers = HashMap<String, Provider>()

        fun fakeitInit(locale: Locale) {
            if (fakeit == null) {
                synchronized(Fakeit::class.java) {
                    if (fakeit == null) {
                        fakeit = Fakeit(locale)
                    }
                }
            }
        }

        @JvmStatic
        fun resetLocale(locale: Locale) {
            fakeit = null
            initWithLocale(locale)
        }

        @JvmStatic
        fun init(): Fakeit {
            initWithLocale("en")
            return fakeit as Fakeit
        }

        @JvmStatic
        fun initWithLocale(locale: Locale): Fakeit {
            fakeitInit(locale)
            return fakeit as Fakeit
        }

        @JvmStatic
        fun initWithLocale(localeString: String): Fakeit = initWithLocale(Locale(localeString))

        @JvmStatic
        fun getUniqueValue(): Boolean = fakeit?.uniqueValueActive ?: false

        @JvmStatic
        fun changeUniqueValueState() {
            fakeit?.uniqueValueActive = fakeit?.let { !it.uniqueValueActive } ?: false
        }

        private fun getProvider(key: String, provider: () -> Provider): Provider {
            if (fakeit == null) {
                throw Exception("Fake it not ready. Did you forgot to call init?")
            } else {
                return providers[key].let { it } ?: {
                    val auxProvider = provider()
                    providers.put(key, auxProvider)
                    auxProvider
                }()
            }
        }

        @JvmStatic
        fun name(): NameProvider = getProvider("name", { NameProviderImpl() }) as NameProvider

        @JvmStatic
        fun business(): BusinessProvider = getProvider("business", { BusinessProviderImpl() }) as BusinessProvider

        @JvmStatic
        fun address(): AddressProvider = getProvider("address", { AddressProviderImpl() }) as AddressProvider

        @JvmStatic
        fun app(): AppProvider = getProvider("app", { AppProviderImpl() }) as AppProvider

        @JvmStatic
        fun card(): CardProvider = getProvider("card", { CardProviderImpl() }) as CardProvider

        @JvmStatic
        fun ancient(): AncientProvider = getProvider("ancient", { AncientProviderImpl() }) as AncientProvider

        @JvmStatic
        fun artist(): ArtistProvider = getProvider("artist", { ArtistProviderImpl() }) as ArtistProvider

        @JvmStatic
        fun bank(): BankProvider = getProvider("bank", { BankProviderImpl() }) as BankProvider

        @JvmStatic
        fun beer(): BeerProvider = getProvider("beer", { BeerProviderImpl() }) as BeerProvider

        @JvmStatic
        fun book(): BookProvider = getProvider("book", { BookProviderImpl() }) as BookProvider

        @JvmStatic
        fun cat(): CatProvider = getProvider("cat", { CatProviderImpl() }) as CatProvider

        @JvmStatic
        fun chuckNorris(): ChuckNorrisFactsProvider = getProvider("chuckNorris", { ChuckNorrisFactsProviderImpl() }) as ChuckNorrisFactsProvider

        @JvmStatic
        fun code(): CodeProvider = getProvider("code", { CodeProviderImpl() }) as CodeProvider

        @JvmStatic
        fun company(): CompanyProvider = getProvider("company", { CompanyProviderImpl() }) as CompanyProvider

        @JvmStatic
        fun coffee(): CoffeeProvider = getProvider("coffee", { CoffeeProviderImpl() }) as CoffeeProvider

        @JvmStatic
        fun compass(): CompassProvider = getProvider("compass", { CompassProviderImpl() }) as CompassProvider

        @JvmStatic
        fun dateTime(): DateTimeProvider = getProvider("dateTime", { DateTimeProviderImpl() }) as DateTimeProvider

        @JvmStatic
        fun demographic(): DemographicProvider = getProvider("demographic", { DemographicProviderImpl() }) as DemographicProvider

        @JvmStatic
        fun hipster(): HipsterProvider = getProvider("hipster", { HipsterProviderImpl() }) as HipsterProvider

        @JvmStatic
        fun educator(): EducatorProvider = getProvider("educator", { EducatorProviderImpl() }) as EducatorProvider

        @JvmStatic
        fun esports(): EsportProvider = getProvider("esports", { EsportProviderImpl() }) as EsportProvider

        @JvmStatic
        fun internet(): InternetProvider = getProvider("internet", { InternetProviderImpl() }) as InternetProvider

        @JvmStatic
        fun file(): FileProvider = getProvider("file", { FileProviderImpl() }) as FileProvider

        @JvmStatic
        fun food(): FoodProvider = getProvider("food", { FoodProviderImpl() }) as FoodProvider

        @JvmStatic
        fun friends(): FriendsProvider = getProvider("friends", { FriendsProviderImpl() }) as FriendsProvider

        @JvmStatic
        fun gameOfThrones(): GameOfThronesProvider = getProvider("gameOfThrones", { GameOfThronesProviderImpl() }) as GameOfThronesProvider

        @JvmStatic
        fun harryPotter(): HarryPotterProvider = getProvider("harryPotter", { HarryPotterProviderImpl() }) as HarryPotterProvider

        @JvmStatic
        fun hacker(): HackerProvider = getProvider("hacker", { HackerProviderImpl() }) as HackerProvider

        @JvmStatic
        fun job(): JobProvider = getProvider("job", { JobProviderImpl() }) as JobProvider

        @JvmStatic
        fun lorem(): LoremProvider = getProvider("lorem", { LoremProviderImpl() }) as LoremProvider

        @JvmStatic
        fun lordOfTheRings(): LordOfTheRingsProvider = getProvider("lordOfTheRings", { LordOfTheRingsProviderImpl() }) as LordOfTheRingsProvider

        @JvmStatic
        fun music(): MusicProvider = getProvider("music", { MusicProviderImpl() }) as MusicProvider

        @JvmStatic
        fun heyArnold(): HeyArnoldProvider = getProvider("heyArnold", { HeyArnoldProviderImpl() }) as HeyArnoldProvider

        @JvmStatic
        fun pokemon(): PokemonProvider = getProvider("pokemon", { PokemonProviderImpl() }) as PokemonProvider

        @JvmStatic
        fun phone(): PhoneNumberProvider = getProvider("phone", { PhoneNumberProviderImpl() }) as PhoneNumberProvider

        @JvmStatic
        fun rickAndMorty(): RickAndMortyProvider = getProvider("rickAndMorty", { RickAndMortyProviderImpl() }) as RickAndMortyProvider

        @JvmStatic
        fun rockBand(): RockBandProvider = getProvider("rockBand", { RockBandProviderImpl() }) as RockBandProvider
    }
}