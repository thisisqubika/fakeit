package com.mooveit.library.providers.definition

interface PokemonProvider : Provider {

    fun name(): String
    fun location(): String
}