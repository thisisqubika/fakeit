package com.mooveit.library.providers.definition


interface MusicProvider {

    fun key(): String
    fun chord(): String
    fun instrument(): String
    fun keyTypes(): String
    fun chordTypes(): String
}