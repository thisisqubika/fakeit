package com.mooveit.library

import android.content.Context
import com.mooveit.library.providers.AddressProviderImpl
import com.mooveit.library.providers.BusinessProviderImpl
import com.mooveit.library.providers.CardProviderImpl
import com.mooveit.library.providers.NameProviderImpl
import com.mooveit.library.providers.definition.*
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Pattern

class Fakeit private constructor(context: Context, locale: Locale) {

    val numeralAndBracesRegEx = "#\\{(.*?)\\}"
    val businessProvider: BusinessProvider
    val addressProvider: AddressProvider
    val cardProvider: CardProvider
    val yaml = Yaml()
    val values: LinkedHashMap<String, LinkedHashMap<String, String>>

    init {
        val assetManager = context.assets

        val inputStream = assetManager.open(("locales/".plus(locale.language.plus(".yml"))))
        val yamlValues = yaml.load(inputStream) as Map<String, Map<String, String>>
        val localeValues = yamlValues.get(locale.language) as Map<String, Map<String, String>>
        this.values = localeValues.get("faker") as LinkedHashMap<String, LinkedHashMap<String, String>>

        this.businessProvider = BusinessProviderImpl(context.resources)
        this.addressProvider = AddressProviderImpl(context.resources)
        this.cardProvider = CardProviderImpl(context.resources)
    }

    fun fetch(key: String): String {
        val separator = key.indexOf(".")
        val category = key.substring(0, separator)
        val selected = key.substring(separator + 1, key.length)
        val categoryValues = this.values[category] as LinkedHashMap<*, *>
        val selectedValues = categoryValues[selected] as ArrayList<String>

        if (selectedValues[0].matches(Regex(numeralAndBracesRegEx))) {
            return getDataToFetch(category, selectedValues)
        } else {
            return getRandomString(selectedValues)
        }
    }

    fun getDataToFetch(category: String, selectedValues: ArrayList<String>): String {
        val setOfValueNames = getRandomString(selectedValues)
        val matcher = Pattern.compile(numeralAndBracesRegEx).matcher(setOfValueNames)
        val stringBuffer = StringBuffer()
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, fetchValueByCategory(category, matcher.group(1)))
        }
        matcher.appendTail(stringBuffer)
        return stringBuffer.toString()
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
        return getRandomString(selectedValues)
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
            return checkInitialization({ Fakeit.fakeit!!.businessProvider }) as BusinessProvider
        }

        @JvmStatic
        fun address(): AddressProvider {
            return checkInitialization({ Fakeit.fakeit!!.addressProvider }) as AddressProvider
        }

        @JvmStatic
        fun card(): CardProvider {
            return checkInitialization({ Fakeit.fakeit!!.cardProvider }) as CardProvider
        }

        fun checkInitialization(method: () -> Provider): Provider {
            if (fakeit == null) {
                throw Throwable(IllegalArgumentException("Fake it must be initialized before start"))
            } else {
                return method()
            }
        }
    }
}
