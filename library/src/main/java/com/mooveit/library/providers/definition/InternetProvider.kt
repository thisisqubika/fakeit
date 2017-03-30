package com.mooveit.library.providers.definition

interface InternetProvider {

    fun freeEmail(): String
    fun domainSuffix(): String
}