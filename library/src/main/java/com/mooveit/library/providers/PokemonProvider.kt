package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.PokemonProvider

class PokemonProvider : BaseProvider(), PokemonProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("pokemon.names") })
    }

    override fun location(): String {
        return getValue("location", { fakeit!!.fetch("pokemon.locations") })
    }
}