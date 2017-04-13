package com.mooveit.library

import android.content.Context
import android.content.res.AssetManager
import com.mooveit.library.providers.*
import com.mooveit.library.providers.definition.*
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.LinkedHashMap

class Fakeit private constructor(context: Context, locale: Locale) {

    val numeralAndBracesRegEx = "#\\{(.*?)\\}"
    val numeralRegEx = ".*#(\\{[^a-zA-z]|[^{])+"
    val numeralOnlyRegEx = "#"
    val defaultLanguage = "en"
    val yaml = Yaml()
    val fakeValues: LinkedHashMap<String, LinkedHashMap<String, String>>
    val fakeValuesDefaults: LinkedHashMap<String, LinkedHashMap<String, String>>

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
        fun name(): NameProvider {
            return NameProviderImpl()
        }

        @JvmStatic
        fun business(): BusinessProvider {
            return BusinessProviderImpl()
        }

        @JvmStatic
        fun address(): AddressProvider {
            return AddressProviderImpl()
        }

        @JvmStatic
        fun app(): AppProvider {
            return AppProviderImpl()
        }

        @JvmStatic
        fun card(): CardProvider {
            return CardProviderImpl()
        }

        @JvmStatic
        fun ancient(): AncientProvider {
            return AncientProviderImpl()
        }

        @JvmStatic
        fun artist(): ArtistProvider {
            return ArtistProviderImpl()
        }

        @JvmStatic
        fun bank(): BankProvider {
            return BankProviderImpl()
        }

        @JvmStatic
        fun beer(): BeerProvider {
            return BeerProviderImpl()
        }

        @JvmStatic
        fun book(): BookProvider {
            return BookProviderImpl()
        }

        @JvmStatic
        fun cat(): CatProvider {
            return CatProviderImpl()
        }

        @JvmStatic
        fun chuckNorris(): ChuckNorrisFactsProvider {
            return ChuckNorrisFactsProviderImpl()
        }

        @JvmStatic
        fun code(): CodeProvider {
            return CodeProviderImpl()
        }

        @JvmStatic
        fun company(): CompanyProvider {
            return CompanyProviderImpl()
        }

        @JvmStatic
        fun compass(): CompassProvider {
            return CompassProviderImpl()
        }

        @JvmStatic
        fun demographic(): DemographicProvider {
            return DemographicProviderImpl()
        }

        @JvmStatic
        fun hipster(): HipsterProvider {
            return HipsterProviderImpl()
        }

        @JvmStatic
        fun educator(): EducatorProvider {
            return EducatorProviderImpl()
        }

        @JvmStatic
        fun esports(): EsportProvider {
            return EsportProviderImpl()
        }

        @JvmStatic
        fun internet(): InternetProvider {
            return InternetProviderImpl()
        }

        @JvmStatic
        fun file(): FileProvider {
            return FileProviderImpl()
        }

        @JvmStatic
        fun food(): FoodProvider {
            return FoodProviderImpl()
        }

        @JvmStatic
        fun friends(): FriendsProvider {
            return FriendsProviderImpl()
        }

        @JvmStatic
        fun gameOfThrones(): GameOfThronesProvider {
            return GameOfThronesProviderImpl()
        }

        @JvmStatic
        fun harryPotter(): HarryPotterProvider {
            return HarryPotterProviderImpl()
        }

        @JvmStatic
        fun hacker(): HackerProvider {
            return HackerProviderImpl()
        }

        @JvmStatic
        fun job(): JobProvider {
            return JobProviderImpl()
        }

        @JvmStatic
        fun lorem(): LoremProvider {
            return LoremProviderImpl()
        }

        @JvmStatic
        fun lordOfTheRings(): LordOfTheRingsProvider {
            return LordOfTheRingsProviderImpl()
        }

        @JvmStatic
        fun music(): MusicProvider {
            return MusicProviderImpl()
        }

        @JvmStatic
        fun heyArnold(): HeyArnoldProvider {
            return HeyArnoldProviderImpl()
        }

        @JvmStatic
        fun pokemon(): PokemonProvider {
            return PokemonProviderImpl()
        }

        @JvmStatic
        fun phone(): PhoneNumberProvider {
            return PhoneNumberProviderImpl()
        }

        @JvmStatic
        fun rickAndMorty(): RickAndMortyProvider {
            return RickAndMortyProviderImpl()
        }

        @JvmStatic
        fun rockBand(): RockBandProvider {
            return RockBandProviderImpl()
        }
    }
}