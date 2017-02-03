package com.mooveit.library.providers.definition

interface BusinessProvider : Provider {

    fun name(): String
    fun type(): String
    fun subType(): String
}