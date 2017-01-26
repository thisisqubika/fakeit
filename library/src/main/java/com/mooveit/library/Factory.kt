package com.mooveit.library

import android.content.Context

import com.mooveit.library.providers.NameProviderImpl
import com.mooveit.library.providers.definition.NameProvider

class Factory private constructor(context: Context) {

    private val mNameProvider: NameProvider

    init {
        this.mNameProvider = NameProviderImpl(context)
    }

    companion object FakeIt {

        var mFactory: Factory? = null

        fun with(context: Context): Factory {
            if (mFactory == null) {
                synchronized(Factory::class.java) {
                    if (mFactory == null) {
                        mFactory = Factory(context)
                    }
                }
            }
            return mFactory as Factory
        }

        fun name(context: Context): NameProvider {
            return Factory.with(context).mNameProvider
        }
    }
}
