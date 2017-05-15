package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.HackerProvider

class HackerProvider : BaseProvider(), HackerProvider {

    override fun abbreviation(): String {
        return getValue("abbreviation", { fakeit!!.fetch("hacker.abbreviation") })
    }

    override fun adjective(): String {
        return getValue("adjective", { fakeit!!.fetch("hacker.adjective") })
    }

    override fun noun(): String {
        return getValue("noun", { fakeit!!.fetch("hacker.noun") })
    }

    override fun verb(): String {
        return getValue("verb", { fakeit!!.fetch("hacker.verb") })
    }

    override fun ingverb(): String {
        return getValue("ingverb", { fakeit!!.fetch("hacker.ingverb") })
    }
}