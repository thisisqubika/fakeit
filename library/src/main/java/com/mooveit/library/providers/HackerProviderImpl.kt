package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.HackerProvider

class HackerProviderImpl : HackerProvider {

    override fun abbreviation(): String {
        return fakeit!!.fetch("hacker.abbreviation")
    }

    override fun adjective(): String {
        return fakeit!!.fetch("hacker.adjective")
    }

    override fun noun(): String {
        return fakeit!!.fetch("hacker.noun")
    }

    override fun verb(): String {
        return fakeit!!.fetch("hacker.verb")
    }

    override fun ingverb(): String {
        return fakeit!!.fetch("hacker.ingverb")
    }
}