package com.mooveit.library.providers.definition

interface RickAndMortyProvider {

    fun character(): String
    fun location(): String
    fun quote(): String
}