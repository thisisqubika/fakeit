package com.mooveit.library.providers.definition

interface ChuckNorrisFactsProvider : Provider {

    fun fact(): String
}