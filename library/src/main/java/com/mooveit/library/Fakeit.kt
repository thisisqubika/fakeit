package com.mooveit.library

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.mooveit.library.providers.BusinessProviderImpl
import com.mooveit.library.providers.NameProviderImpl
import com.mooveit.library.providers.definition.BusinessProvider
import com.mooveit.library.providers.definition.NameProvider
import java.util.*

class Fakeit private constructor(context: Context, locale: Locale) {

    val nameProvider: NameProvider
    var businessProvider: BusinessProvider

    init {
        var resources: Resources = context.resources
        var configuration: Configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, null)

        this.nameProvider = NameProviderImpl(resources)
        this.businessProvider = BusinessProviderImpl(resources)
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
            fakeitInit(context, context.getResources().getConfiguration().locale)
            return fakeit as Fakeit
        }

        @JvmStatic
        fun initWithLocale(context: Context, locale: Locale): Fakeit {
            fakeitInit(context, locale)
            return fakeit as Fakeit
        }

        @JvmStatic
        fun initWithLocale(context: Context, localeString: String): Fakeit {
            var locale: Locale = Locale(localeString)
            return initWithLocale(context, locale)
        }

        @JvmStatic
        fun name(): NameProvider {
            if (fakeit == null) {
                throw IllegalArgumentException("Fake it must be initialized before start")
            } else {
                return Fakeit.fakeit!!.nameProvider
            }
        }

        @JvmStatic
        fun business(): BusinessProvider {
            if (fakeit == null) {
                throw IllegalArgumentException("Fake it must be initialized before start")
            } else {
                return Fakeit.fakeit!!.businessProvider
            }
        }
    }
}
