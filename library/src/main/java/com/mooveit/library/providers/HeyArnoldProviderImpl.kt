package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.HeyArnoldProvider

class HeyArnoldProviderImpl : HeyArnoldProvider {

    override fun character(): String {
        return fakeit!!.fetch("hey_arnold.characters")
    }

    override fun location(): String {
        return fakeit!!.fetch("hey_arnold.locations")
    }

    override fun quote(): String {
        return fakeit!!.fetch("hey_arnold.quotes")
    }
}