package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.HarryPotterProvider

class HarryPotterProviderImpl : HarryPotterProvider {

    override fun character(): String {
        return fakeit!!.fetch("harry_potter.characters")
    }

    override fun location(): String {
        return fakeit!!.fetch("harry_potter.locations")
    }

    override fun quote(): String {
        return fakeit!!.fetch("harry_potter.quotes")
    }

    override fun book(): String {
        return fakeit!!.fetch("harry_potter.books")
    }
}