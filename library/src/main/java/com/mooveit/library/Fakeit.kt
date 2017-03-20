package com.mooveit.library

import android.content.Context
import android.content.res.AssetManager
import com.mooveit.library.providers.*
import com.mooveit.library.providers.definition.*
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class Fakeit private constructor(context: Context, locale: Locale) {

    val numeralAndBracesRegEx = "#\\{(.*?)\\}"
    val numeralRegEx = ".*#(\\{[^a-zA-z]|[^{])+"
    val numeralOnlyRegEx = "#"
    val defaultLanguage = "en"
    val yaml = Yaml()
    val values: LinkedHashMap<String, LinkedHashMap<String, String>>
    val valuesDefaults: LinkedHashMap<String, LinkedHashMap<String, String>>

    init {
        val assetManager = context.assets
        this.values = getValues(locale.language, assetManager)
        if (locale.language != defaultLanguage) {
            this.valuesDefaults = getValues(defaultLanguage, assetManager)
        } else {
            this.valuesDefaults = LinkedHashMap()
        }
    }

    fun getValues(language: String, assetManager: AssetManager): LinkedHashMap<String, LinkedHashMap<String, String>> {
        val inputStreamDefault = assetManager.open(("locales/".plus(language.plus(".yml"))))
        val yamlValuesDefault = yaml.load(inputStreamDefault) as Map<*, *>
        val localeValuesDefault = yamlValuesDefault[language] as Map<*, *>
        return localeValuesDefault["faker"] as LinkedHashMap<String, LinkedHashMap<String, String>>
    }

    fun getResourceNotFound(key: String): String {
        return "Resource not found $key"
    }

    fun fetchCategoryValues(key: String, category: String,
                            valuesToFetch: LinkedHashMap<String, LinkedHashMap<String, String>>): LinkedHashMap<*, *> {
        var separator = category.indexOf(".")
        var subCategory = category
        var values = valuesToFetch
        var check = true
        if (separator == -1 && values[subCategory] == null) {
            if (this.valuesDefaults.size == 0) {
                throw Exception(getResourceNotFound(key))
            }
            values = this.valuesDefaults
        }
        while (separator != -1) {
            if (values[subCategory.substring(0, separator)] == null) {
                if (!check || this.valuesDefaults.size == 0) {
                    throw Exception(getResourceNotFound(key))
                }
                separator = category.indexOf(".")
                subCategory = category
                values = this.valuesDefaults
                check = false
            }
            values = values[subCategory.substring(0, separator)] as LinkedHashMap<String, LinkedHashMap<String, String>>
            subCategory = subCategory.substring(separator + 1, subCategory.length)
            separator = subCategory.indexOf(".")
        }
        if (values[subCategory] is LinkedHashMap<*, *>) {
            return values[subCategory] as LinkedHashMap<*, *>
        } else {
            throw Exception("Resource Key not found $category on $key")
        }
    }

    fun fetchSelectedValue(key: String, category: String, selected: String): ArrayList<String> {
        var categoryValues = fetchCategoryValues(key, category, this.values)
        if (categoryValues[selected] == null) {
            if (this.valuesDefaults.size == 0) {
                throw Exception(getResourceNotFound(key))
            }
            categoryValues = fetchCategoryValues(key, category, this.valuesDefaults)
            if (categoryValues[selected] == null) {
                throw Exception(getResourceNotFound(key))
            }
        }
        if (categoryValues[selected] is ArrayList<*>) {
            return categoryValues[selected] as ArrayList<String>
        } else {
            throw Exception("Resource $category.$selected is not a value")
        }
    }

    fun fetch(key: String): String {
        val separator = key.lastIndexOf(".")
        val category = key.substring(0, separator)
        val selected = key.substring(separator + 1, key.length)
        val selectedValues = fetchSelectedValue(key, category, selected)

        if (selectedValues[0].matches(Regex(numeralAndBracesRegEx))) {
            return getDataToFetch(category, selectedValues)
        } else if (selectedValues[0].matches(Regex(numeralRegEx))) {
            return fetchNumerals(selectedValues)
        } else {
            return getRandomString(selectedValues)
        }
    }

    fun matchAndReplace(stringToMatch: String, stringBuffer: StringBuffer, regExp: String, method: (Matcher) -> Matcher): String {
        val matcher = Pattern.compile(regExp).matcher(stringToMatch)
        while (matcher.find()) {
            method(matcher)
        }
        matcher.appendTail(stringBuffer)
        return stringBuffer.toString()
    }

    fun fetchNumerals(selectedValues: ArrayList<String>): String {
        val numeral = getRandomString(selectedValues)
        val stringBuffer = StringBuffer()
        return matchAndReplace(numeral, stringBuffer, numeralOnlyRegEx,
                { matcher -> matcher.appendReplacement(stringBuffer, Random().nextInt(10).toString()) })
    }

    fun getDataToFetch(category: String, selectedValues: ArrayList<String>): String {
        val setOfValues = getRandomString(selectedValues)
        val stringBuffer = StringBuffer()
        return matchAndReplace(setOfValues, stringBuffer, numeralAndBracesRegEx,
                { matcher -> matcher.appendReplacement(stringBuffer, fetchValueByCategory(category, matcher.group(1))) })
    }

    fun fetchValueByCategory(category: String, key: String): String {
        val separator = key.indexOf(".")
        var dataCategory = category
        var keyToFetch = key
        if (separator != -1) {
            dataCategory = key.substring(0, separator).toLowerCase()
            keyToFetch = key.substring(separator + 1, key.length)
        }
        val categoryValues = this.values[dataCategory] as LinkedHashMap<String, ArrayList<String>>
        val selectedValues = categoryValues[keyToFetch] as ArrayList<String>

        var result = getRandomString(selectedValues)
        if (result.matches(Regex(numeralRegEx))) {
            result = fetchNumerals(selectedValues)
        }
        if (selectedValues[0].matches(Regex(numeralAndBracesRegEx))) {
            result = getDataToFetch(category, selectedValues)
        }
        return result
    }

    fun getRandomString(selectedValues: ArrayList<String>): String {
        return selectedValues[Random().nextInt(selectedValues.size)]
    }

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
        fun init(context: Context): Fakeit {
            fakeitInit(context, Locale.getDefault())
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
        fun compass(): CompassProvider {
            return CompassProviderImpl()
        }

        @JvmStatic
        fun demographic(): DemographicProvider {
            return DemographicProviderImpl()
        }

        @JvmStatic
        fun esports(): EsportProvider {
            return EsportProviderImpl()
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
        

    }
}