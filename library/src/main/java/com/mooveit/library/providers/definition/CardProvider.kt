package com.mooveit.library.providers.definition

interface CardProvider : Provider {

    fun name(): String
    fun brand(): String
    fun number(): String
    fun type(): String
    fun expirationDate(): String
}
