package com.mooveit.library

import android.content.Context

import com.mooveit.library.providers.NameProviderImpl
import com.mooveit.library.providers.definition.NameProvider

class Fakeit private constructor(context: Context) {

    val nameProvider: NameProvider

    init {
        this.nameProvider = NameProviderImpl(context)
    }

    companion object Companion {

        var fakeit: Fakeit? = null

        @JvmStatic
        fun init(context: Context): Fakeit {
            if (fakeit == null) {
                synchronized(Fakeit::class.java) {
                    if (fakeit == null) {
                        fakeit = Fakeit(context)
                    }
                }
            }
            return fakeit as Fakeit
        }

        @JvmStatic
        fun name(): NameProvider {
            if (fakeit == null) {
                throw IllegalArgumentException("Fake it must be initialized before start")
            } else  {
                return Fakeit.fakeit!!.nameProvider
            }
        }
    }
}
