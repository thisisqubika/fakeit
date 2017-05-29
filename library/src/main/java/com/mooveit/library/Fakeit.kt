package com.mooveit.library

import android.content.Context
import android.content.res.AssetManager
import com.mooveit.library.providers.definition.*
import com.mooveit.library.providers.definition.AddressProvider
import com.mooveit.library.providers.definition.AncientProvider
import com.mooveit.library.providers.definition.AppProvider
import com.mooveit.library.providers.definition.ArtistProvider
import com.mooveit.library.providers.definition.BankProvider
import com.mooveit.library.providers.definition.BeerProvider
import com.mooveit.library.providers.definition.BookProvider
import com.mooveit.library.providers.definition.BusinessProvider
import com.mooveit.library.providers.definition.CardProvider
import com.mooveit.library.providers.definition.CatProvider
import com.mooveit.library.providers.definition.ChuckNorrisFactsProvider
import com.mooveit.library.providers.definition.CodeProvider
import com.mooveit.library.providers.definition.CompanyProvider
import com.mooveit.library.providers.definition.CompassProvider
import com.mooveit.library.providers.definition.DemographicProvider
import com.mooveit.library.providers.definition.EducatorProvider
import com.mooveit.library.providers.definition.EsportProvider
import com.mooveit.library.providers.definition.FileProvider
import com.mooveit.library.providers.definition.FoodProvider
import com.mooveit.library.providers.definition.FriendsProvider
import com.mooveit.library.providers.definition.GameOfThronesProvider
import com.mooveit.library.providers.definition.HackerProvider
import com.mooveit.library.providers.definition.HarryPotterProvider
import com.mooveit.library.providers.definition.HeyArnoldProvider
import com.mooveit.library.providers.definition.HipsterProvider
import com.mooveit.library.providers.definition.InternetProvider
import com.mooveit.library.providers.definition.JobProvider
import com.mooveit.library.providers.definition.LordOfTheRingsProvider
import com.mooveit.library.providers.definition.LoremProvider
import com.mooveit.library.providers.definition.MusicProvider
import com.mooveit.library.providers.definition.NameProvider
import com.mooveit.library.providers.definition.PhoneNumberProvider
import com.mooveit.library.providers.definition.PokemonProvider
import com.mooveit.library.providers.definition.RickAndMortyProvider
import com.mooveit.library.providers.definition.RockBandProvider
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class Fakeit private constructor(context: Context, locale: Locale) {

    val numeralAndBracesRegEx = "#\\{(.*?)\\}"
    val numeralRegEx = ".*#(\\{[^a-zA-z]|[^{])+"
    val numeralOnlyRegEx = "#"
    val defaultLanguage = "en"

    val yaml = Yaml()
    val fakeValues: LinkedHashMap<String, LinkedHashMap<String, String>>
    val fakeValuesDefaults: LinkedHashMap<String, LinkedHashMap<String, String>>

    var uniqueValueActive = false

    init {
        val assetManager = context.assets
        var stringLocale = locale.language

        if (!locale.country.isEmpty()) {
            stringLocale = stringLocale.plus("-").plus(locale.country)
        }

        this.fakeValues = getValues(stringLocale, assetManager)
        if (locale.language != defaultLanguage) {
            this.fakeValuesDefaults = getValues(defaultLanguage, assetManager)
        } else {
            this.fakeValuesDefaults = LinkedHashMap()
        }
    }

    fun getValues(language: String, assetManager: AssetManager): LinkedHashMap<String, LinkedHashMap<String, String>> {
        val inputStreamDefault = assetManager.open(("locales/".plus(language.plus(".yml"))))
        val yamlValuesDefault = yaml.load(inputStreamDefault) as Map<*, *>
        val localeValuesDefault = yamlValuesDefault[language] as Map<*, *>
        return localeValuesDefault["faker"] as LinkedHashMap<String, LinkedHashMap<String, String>>
    }

    fun fetchCategory(key: String, category: String, check: Boolean,
                      valuesToFetch: LinkedHashMap<String, LinkedHashMap<String, String>>): LinkedHashMap<*, *> {
        var (_, subCategory, _, values) = getCategoryAndValues(key, Params(category.indexOf("."), category, check, valuesToFetch))
        if (values[subCategory] is LinkedHashMap<*, *>) {
            return values[subCategory] as LinkedHashMap<*, *>
        } else if (values[subCategory] is ArrayList<*>) {
            var valuesList = values[subCategory] as ArrayList<LinkedHashMap<*, *>>
            return valuesList[Random().nextInt(valuesList.size)]
        } else {
            throw Exception("Resource Key not found $category on $key")
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
        if (categoryValues[selected] is ArrayList<*>) {
            var values = categoryValues[selected] as ArrayList<ArrayList<String>>
            if (values[0] is CharSequence) {
                return getRandomString(values as ArrayList<String>)
            }
            return getRandomString(values[Random().nextInt(values.size)])
        } else if (categoryValues[selected] is String) {
            return categoryValues[selected] as String
        } else {
            throw Exception("Resource $category.$selected is not a value")
        }
    }

    fun fetch(key: String): String {
        val separator = key.lastIndexOf(".")
        val category = key.substring(0, separator)
        val selected = key.substring(separator + 1, key.length)
        val selectedValue = fetchSelectedValue(key, category, selected)

        if (selectedValue.matches(Regex(numeralAndBracesRegEx))) {
            return fetchKeyValueData(category, selectedValue)
        } else if (selectedValue.matches(Regex(numeralRegEx))) {
            return fetchNumerals(selectedValue)
        } else {
            return selectedValue
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
            val categoryValues = this.fakeValues[dataCategory] as LinkedHashMap<String, ArrayList<String>>
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

    fun getRandomString(selectedValues: ArrayList<String>): String {
        return selectedValues[Random().nextInt(selectedValues.size)]
    }

    fun getResourceNotFound(key: String): String {
        return "Resource not found $key"
    }

    data class Params(var separator: Int, var category: String, var check: Boolean,
                      var values: LinkedHashMap<String, LinkedHashMap<String, String>>)

    companion object Companion {

        var fakeit: Fakeit? = null
        var providers = HashMap<String, Provider>()

        fun fakeitInit(context: Context, locale: Locale) {
            if (fakeit == null) {
                synchronized(Fakeit::class.java) {
                    if (fakeit == null) {
                        fakeit = Fakeit(context, locale)
                    }
                }
            }
        }

        @JvmStatic
        fun resetLocale(context: Context, locale: Locale) {
            fakeit = null
            initWithLocale(context, locale)
        }

        @JvmStatic
        fun init(context: Context): Fakeit {
            initWithLocale(context, "en")
            return fakeit as Fakeit
        }

        @JvmStatic
        fun initWithLocale(context: Context, locale: Locale): Fakeit {
            fakeitInit(context, locale)
            return fakeit as Fakeit
        }

        @JvmStatic
        fun initWithLocale(context: Context, localeString: String): Fakeit {
            return initWithLocale(context, Locale(localeString))
        }

        @JvmStatic
        fun getUniqueValue(): Boolean {
            return fakeit?.let { it.uniqueValueActive } ?: false
        }

        @JvmStatic
        fun changeUniqueValueState() {
            fakeit?.uniqueValueActive = fakeit?.let { !it.uniqueValueActive } ?: false
        }

        private fun getProvider(key: String, provider: () -> Provider): Provider {
            return providers[key].let { it } ?: {
                val auxProvider = provider()
                providers.put(key, auxProvider)
                auxProvider
            }()
        }

        @JvmStatic
        fun name(): NameProvider {
            return getProvider("name", { com.mooveit.library.providers.NameProvider() }) as NameProvider
        }

        @JvmStatic
        fun business(): BusinessProvider {
            return getProvider("business", { com.mooveit.library.providers.BusinessProvider() }) as BusinessProvider
        }

        @JvmStatic
        fun address(): AddressProvider {
            return getProvider("address", { com.mooveit.library.providers.AddressProvider() }) as AddressProvider
        }

        @JvmStatic
        fun app(): AppProvider {
            return getProvider("app", { com.mooveit.library.providers.AppProvider() }) as AppProvider
        }

        @JvmStatic
        fun card(): CardProvider {
            return getProvider("card", { com.mooveit.library.providers.CardProvider() }) as CardProvider
        }

        @JvmStatic
        fun ancient(): AncientProvider {
            return getProvider("ancient", { com.mooveit.library.providers.AncientProvider() }) as AncientProvider
        }

        @JvmStatic
        fun artist(): ArtistProvider {
            return getProvider("artist", { com.mooveit.library.providers.ArtistProvider() }) as ArtistProvider
        }

        @JvmStatic
        fun bank(): BankProvider {
            return getProvider("bank", { com.mooveit.library.providers.BankProvider() }) as BankProvider
        }

        @JvmStatic
        fun beer(): BeerProvider {
            return getProvider("beer", { com.mooveit.library.providers.BeerProvider() }) as BeerProvider
        }

        @JvmStatic
        fun book(): BookProvider {
            return getProvider("book", { com.mooveit.library.providers.BookProvider() }) as BookProvider
        }

        @JvmStatic
        fun cat(): CatProvider {
            return getProvider("cat", { com.mooveit.library.providers.CatProvider() }) as CatProvider
        }

        @JvmStatic
        fun chuckNorris(): ChuckNorrisFactsProvider {
            return getProvider("chuckNorris", { com.mooveit.library.providers.ChuckNorrisFactsProvider() }) as ChuckNorrisFactsProvider
        }

        @JvmStatic
        fun code(): CodeProvider {
            return getProvider("code", { com.mooveit.library.providers.CodeProvider() }) as CodeProvider
        }

        @JvmStatic
        fun company(): CompanyProvider {
            return getProvider("company", { com.mooveit.library.providers.CompanyProvider() }) as CompanyProvider
        }

        @JvmStatic
        fun compass(): CompassProvider {
            return getProvider("compass", { com.mooveit.library.providers.CompassProvider() }) as CompassProvider
        }

        @JvmStatic
        fun dateTime(): DateTimeProvider {
            return DateTimeProviderImpl()
        }

        @JvmStatic
        fun demographic(): DemographicProvider {
            return getProvider("demographic", { com.mooveit.library.providers.DemographicProvider() }) as DemographicProvider
        }

        @JvmStatic
        fun hipster(): HipsterProvider {
            return getProvider("hipster", { com.mooveit.library.providers.HipsterProvider() }) as HipsterProvider
        }

        @JvmStatic
        fun educator(): EducatorProvider {
            return getProvider("educator", { com.mooveit.library.providers.EducatorProvider() }) as EducatorProvider
        }

        @JvmStatic
        fun esports(): EsportProvider {
            return getProvider("esports", { com.mooveit.library.providers.EsportProvider() }) as EsportProvider
        }

        @JvmStatic
        fun internet(): InternetProvider {
            return getProvider("internet", { com.mooveit.library.providers.InternetProvider() }) as InternetProvider
        }

        @JvmStatic
        fun file(): FileProvider {
            return getProvider("file", { com.mooveit.library.providers.FileProvider() }) as FileProvider
        }

        @JvmStatic
        fun food(): FoodProvider {
            return getProvider("food", { com.mooveit.library.providers.FoodProvider() }) as FoodProvider
        }

        @JvmStatic
        fun friends(): FriendsProvider {
            return getProvider("friends", { com.mooveit.library.providers.FriendsProvider() }) as FriendsProvider
        }

        @JvmStatic
        fun gameOfThrones(): GameOfThronesProvider {
            return getProvider("gameOfThrones", { com.mooveit.library.providers.GameOfThronesProvider() }) as GameOfThronesProvider
        }

        @JvmStatic
        fun harryPotter(): HarryPotterProvider {
            return getProvider("harryPotter", { com.mooveit.library.providers.HarryPotterProvider() }) as HarryPotterProvider
        }

        @JvmStatic
        fun hacker(): HackerProvider {
            return getProvider("hacker", { com.mooveit.library.providers.HackerProvider() }) as HackerProvider
        }

        @JvmStatic
        fun job(): JobProvider {
            return getProvider("job", { com.mooveit.library.providers.JobProvider() }) as JobProvider
        }

        @JvmStatic
        fun lorem(): LoremProvider {
            return getProvider("lorem", { com.mooveit.library.providers.LoremProvider() }) as LoremProvider
        }

        @JvmStatic
        fun lordOfTheRings(): LordOfTheRingsProvider {
            return getProvider("lordOfTheRings", { com.mooveit.library.providers.LordOfTheRingsProvider() }) as LordOfTheRingsProvider
        }

        @JvmStatic
        fun music(): MusicProvider {
            return getProvider("music", { com.mooveit.library.providers.MusicProvider() }) as MusicProvider
        }

        @JvmStatic
        fun heyArnold(): HeyArnoldProvider {
            return getProvider("heyArnold", { com.mooveit.library.providers.HeyArnoldProvider() }) as HeyArnoldProvider
        }

        @JvmStatic
        fun pokemon(): PokemonProvider {
            return getProvider("pokemon", { com.mooveit.library.providers.PokemonProvider() }) as PokemonProvider
        }

        @JvmStatic
        fun phone(): PhoneNumberProvider {
            return getProvider("phone", { com.mooveit.library.providers.PhoneNumberProvider() }) as PhoneNumberProvider
        }

        @JvmStatic
        fun rickAndMorty(): RickAndMortyProvider {
            return getProvider("rickAndMorty", { com.mooveit.library.providers.RickAndMortyProvider() }) as RickAndMortyProvider
        }

        @JvmStatic
        fun rockBand(): RockBandProvider {
            return getProvider("rockBand", { com.mooveit.library.providers.RockBandProvider() }) as RockBandProvider
        }
    }
}