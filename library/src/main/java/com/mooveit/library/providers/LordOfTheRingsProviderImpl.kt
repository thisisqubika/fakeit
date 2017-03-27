package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.LordOfTheRingsProvider

class LordOfTheRingsProviderImpl : LordOfTheRingsProvider {

    override fun character(): String {
        return fakeit!!.fetch("lord_of_the_rings.characters")
    }

    override fun location(): String {
        return fakeit!!.fetch("lord_of_the_rings.locations")
    }
}