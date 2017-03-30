package com.mooveit.library.providers.definition

interface AppProvider : Provider {

    fun name(): String
    fun version(): String
    fun author(): String
}