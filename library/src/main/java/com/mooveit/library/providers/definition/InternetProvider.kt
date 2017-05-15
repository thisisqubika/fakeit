package com.mooveit.library.providers.definition

interface InternetProvider : Provider {

    fun freeEmail(): String
    fun domainSuffix(): String
}