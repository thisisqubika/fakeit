package com.mooveit.library

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.mooveit.library.providers.AddressProviderImpl
import com.mooveit.library.providers.BusinessProviderImpl
import com.mooveit.library.providers.DateProviderImpl
import com.mooveit.library.providers.CardProviderImpl
import com.mooveit.library.providers.NameProviderImpl
import com.mooveit.library.providers.definition.*
import java.util.*

class Fakeit private constructor(context: Context, locale: Locale) {

    val nameProvider: NameProvider
    var businessProvider: BusinessProvider
    val addressProvider: AddressProvider
    val cardProvider: CardProvider
    val dateProvider: DateProvider

    init {
        var resources: Resources = context.resources
        var configuration: Configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, null)

        this.nameProvider = NameProviderImpl(resources)
        this.businessProvider = BusinessProviderImpl(resources)
        this.addressProvider = AddressProviderImpl(resources)
        this.cardProvider = CardProviderImpl(resources)
        this.dateProvider = DateProviderImpl(resources)
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
            return checkInitialization({ Fakeit.fakeit!!.nameProvider }) as NameProvider
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

        @JvmStatic
        fun date(): DateProvider {
            return checkInitialization({ Fakeit.fakeit!!.dateProvider }) as DateProvider
        }

        fun checkInitialization(method: () -> Provider): Provider {
            if (fakeit == null) {
                throw IllegalArgumentException("Fake it must be initialized before start")
            } else {
                return method()
            }
        }
    }
}
