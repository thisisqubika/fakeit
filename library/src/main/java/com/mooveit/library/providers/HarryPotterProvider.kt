package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.HarryPotterProvider

class HarryPotterProvider : BaseProvider(), HarryPotterProvider {

    override fun character(): String {
        return getValue("character", { fakeit!!.fetch("harry_potter.characters") })
    }

    override fun location(): String {
        return getValue("location", { fakeit!!.fetch("harry_potter.locations") })
    }

    override fun quote(): String {
        return getValue("quote", { fakeit!!.fetch("harry_potter.quotes") })
    }

    override fun book(): String {
        return getValue("book", { fakeit!!.fetch("harry_potter.books") })
    }
}