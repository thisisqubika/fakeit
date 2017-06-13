package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.HeyArnoldProvider

class HeyArnoldProviderImpl : BaseProvider(), HeyArnoldProvider {

    override fun character(): String {
        return getValue("character", { fakeit!!.fetch("hey_arnold.characters") })
    }

    override fun location(): String {
        return getValue("location", { fakeit!!.fetch("hey_arnold.locations") })
    }

    override fun quote(): String {
        return getValue("quote", { fakeit!!.fetch("hey_arnold.quotes") })
    }
}