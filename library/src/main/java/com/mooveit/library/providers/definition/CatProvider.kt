package com.mooveit.library.providers.definition

interface CatProvider : Provider {

    fun name(): String
    fun breed(): String
    fun registry(): String
}