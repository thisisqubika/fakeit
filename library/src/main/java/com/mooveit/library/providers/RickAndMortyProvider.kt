package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.RickAndMortyProvider

class RickAndMortyProvider : BaseProvider(), RickAndMortyProvider {

    override fun character(): String {
        return getValue("character", { fakeit!!.fetch("rick_and_morty.characters") })
    }

    override fun location(): String {
        return getValue("location", { fakeit!!.fetch("rick_and_morty.locations") })
    }

    override fun quote(): String {
        return getValue("quote", { fakeit!!.fetch("rick_and_morty.quotes") })
    }
}