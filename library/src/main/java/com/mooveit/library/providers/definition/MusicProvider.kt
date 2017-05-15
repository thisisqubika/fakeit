package com.mooveit.library.providers.definition


interface MusicProvider : Provider {

    fun key(): String
    fun chord(): String
    fun instrument(): String
    fun keyTypes(): String
    fun chordTypes(): String
}