package com.mooveit.library

import com.mooveit.library.providers.*
import com.mooveit.library.providers.definition.*
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap


class Fakeit private constructor(locale: Locale) {

    val numeralAndBracesRegEx = "#\\{(.*?)\\}"
    val numeralRegEx = ".*#(\\{[^a-zA-z]|[^{])+"
    val numeralOnlyRegEx = "#"
    val defaultLanguage = "en"

    val yaml = Yaml()
    val fakeValues: LinkedHashMap<String, LinkedHashMap<String, String>>
    val fakeValuesDefaults: LinkedHashMap<String, LinkedHashMap<String, String>>

    var uniqueValueActive = false

    init {
        var stringLocale = locale.language

        if (!locale.country.isEmpty()) {
            stringLocale = stringLocale.plus("-").plus(locale.country)
        }

        this.fakeValues = getValues(stringLocale)
        if (locale.language != defaultLanguage) {
            this.fakeValuesDefaults = getValues(defaultLanguage)
        } else {
            this.fakeValuesDefaults = LinkedHashMap()
        }
    }

    fun getValues(language: String): LinkedHashMap<String, LinkedHashMap<String, String>> {
        val inputStreamDefault = this.javaClass.classLoader.getResourceAsStream("res/raw/".plus(language).plus(".yml"))
        return if (inputStreamDefault != null) {
            val yamlValuesDefault = yaml.load(inputStreamDefault) as Map<*, *>
            val localeValuesDefault = yamlValuesDefault[language] as Map<*, *>
            localeValuesDefault["faker"] as LinkedHashMap<String, LinkedHashMap<String, String>>
        } else {
            getDefaultValues()
        }
    }

    fun getDefaultValues(): LinkedHashMap<String, LinkedHashMap<String, String>> {
        val inputStreamDefault = this.javaClass.classLoader.getResourceAsStream("res/raw/".plus(defaultLanguage).plus(".yml"))
        val yamlValuesDefault = yaml.load(inputStreamDefault) as Map<*, *>
        val localeValuesDefault = yamlValuesDefault[defaultLanguage] as Map<*, *>
        return localeValuesDefault["faker"] as LinkedHashMap<String, LinkedHashMap<String, String>>
    }

    fun fetchCategory(key: String, category: String, check: Boolean,
                      valuesToFetch: LinkedHashMap<String, LinkedHashMap<String, String>>): LinkedHashMap<*, *> {
        val (_, subCategory, _, values) = getCategoryAndValues(key, Params(category.indexOf("."), category, check, valuesToFetch))
        return when {
            values[subCategory] is LinkedHashMap<*, *> -> values[subCategory] as LinkedHashMap<*, *>
            values[subCategory] is ArrayList<*> -> {
                var valuesList = values[subCategory] as ArrayList<LinkedHashMap<*, *>>
                valuesList[Random().nextInt(valuesList.size)]
            }
            else -> throw Exception("Resource Key not found $category on $key")
        }
    }

    fun getCategoryAndValues(key: String, baseParams: Params): Params {
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

    fun checkAndSetParams(key: String, baseParams: Params, params: Params) {
        if (!params.check || this.fakeValuesDefaults.size == 0) {
            throw Exception(getResourceNotFound(key))
        }
        params.separator = baseParams.category.indexOf(".")
        params.category = baseParams.category
        params.values = this.fakeValuesDefaults
        params.check = false
    }

    fun fetchSelectedValue(key: String, category: String, selected: String): String {
        var categoryValues = fetchCategory(key, category, true, this.fakeValues)
        if (categoryValues[selected] == null) {
            if (this.fakeValuesDefaults.size == 0) {
                throw Exception(getResourceNotFound(key))
            }
            categoryValues = fetchCategory(key, category, false, this.fakeValuesDefaults)
            if (categoryValues[selected] == null) {
                throw Exception(getResourceNotFound(key))
            }
        }
        when {
            categoryValues[selected] is ArrayList<*> -> {
                val values = categoryValues[selected] as ArrayList<ArrayList<String>>
                if (values[0] is CharSequence) {
                    return getRandomString(values as ArrayList<String>)
                }
                return getRandomString(values[Random().nextInt(values.size)])
            }
            categoryValues[selected] is String -> return categoryValues[selected] as String
            else -> throw Exception("Resource $category.$selected is not a value")
        }
    }

    fun fetch(key: String): String {
        val separator = key.lastIndexOf(".")
        val category = key.substring(0, separator)
        val selected = key.substring(separator + 1, key.length)
        val selectedValue = fetchSelectedValue(key, category, selected)

        return when {
            selectedValue.matches(Regex(numeralAndBracesRegEx)) -> fetchKeyValueData(category, selectedValue)
            selectedValue.matches(Regex(numeralRegEx)) -> fetchNumerals(selectedValue)
            else -> selectedValue
        }
    }

    fun fetchNumerals(numeral: String): String {
        val stringBuffer = StringBuffer()
        return matchAndReplace(numeral, stringBuffer, numeralOnlyRegEx,
                { matcher -> matcher.appendReplacement(stringBuffer, Random().nextInt(10).toString()) })
    }

    fun fetchKeyValueData(category: String, selectedValue: String): String {
        val stringBuffer = StringBuffer()
        return matchAndReplace(selectedValue, stringBuffer, numeralAndBracesRegEx,
                { matcher -> matcher.appendReplacement(stringBuffer, fetchValueByCategory(category, matcher.group(1))) })
    }

    fun fetchValueByCategory(category: String, key: String): String {
        val separator = key.lastIndexOf(".")
        var dataCategory = category
        var keyToFetch = key
        var result: String

        if (separator != -1) {
            dataCategory = key.substring(0, separator).toLowerCase()
            keyToFetch = key.substring(separator + 1, key.length)
            result = fetchSelectedValue(key, dataCategory, keyToFetch)
        } else {
            val categoryValues = fakeValues[dataCategory] as? LinkedHashMap<String, ArrayList<String>> ?:
                    fakeValuesDefaults[dataCategory] as LinkedHashMap<String, ArrayList<String>>
            val selectedValues = categoryValues[keyToFetch] as ArrayList<String>
            result = getRandomString(selectedValues)
        }

        if (result.matches(Regex(numeralRegEx))) {
            result = fetchNumerals(result)
        }
        if (result.matches(Regex(numeralAndBracesRegEx))) {
            result = fetchKeyValueData(dataCategory, result)
        }
        return result
    }

    fun matchAndReplace(stringToMatch: String, stringBuffer: StringBuffer, regExp: String, method: (Matcher) -> Matcher): String {
        val matcher = Pattern.compile(regExp).matcher(stringToMatch)
        while (matcher.find()) {
            method(matcher)
        }
        matcher.appendTail(stringBuffer)
        return stringBuffer.toString()
    }

    fun getRandomString(selectedValues: ArrayList<String>): String =
            selectedValues[Random().nextInt(selectedValues.size)]

    fun getResourceNotFound(key: String): String = "Resource not found $key"

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