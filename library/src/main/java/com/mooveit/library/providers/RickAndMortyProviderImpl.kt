package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.RickAndMortyProvider

class RickAndMortyProviderImpl : RickAndMortyProvider {

    override fun character(): String {
        return fakeit!!.fetch("rick_and_morty.characters")
    }

    override fun location(): String {
        return fakeit!!.fetch("rick_and_morty.locations")
    }

    override fun quote(): String {
        return fakeit!!.fetch("rick_and_morty.quotes")
    }
}