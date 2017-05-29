package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.LordOfTheRingsProvider

class LordOfTheRingsProviderImpl : BaseProvider(), LordOfTheRingsProvider {

    override fun character(): String {
        return getValue("character", { fakeit!!.fetch("lord_of_the_rings.characters") })
    }

    override fun location(): String {
        return getValue("location", { fakeit!!.fetch("lord_of_the_rings.locations") })
    }
}