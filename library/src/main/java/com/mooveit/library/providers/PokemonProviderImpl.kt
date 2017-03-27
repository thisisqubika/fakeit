package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.PokemonProvider

class PokemonProviderImpl : PokemonProvider {

    override fun name(): String {
        return fakeit!!.fetch("pokemon.names")
    }

    override fun location(): String {
        return fakeit!!.fetch("pokemon.locations")
    }
}