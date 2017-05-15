package com.mooveit.library.providers.definition

interface EsportProvider : Provider {

    fun player(): String
    fun team(): String
    fun league(): String
    fun event(): String
    fun game(): String
}

