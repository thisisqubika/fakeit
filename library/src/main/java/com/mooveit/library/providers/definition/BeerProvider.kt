package com.mooveit.library.providers.definition

interface BeerProvider : Provider {

    fun name(): String
    fun style(): String
    fun hop(): String
    fun yeast(): String
    fun malts(): String
    fun ibu(): String
    fun alcohol(): String
    fun blg(): String
}