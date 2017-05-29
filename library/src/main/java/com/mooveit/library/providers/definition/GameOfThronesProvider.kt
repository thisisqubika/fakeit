package com.mooveit.library.providers.definition

interface GameOfThronesProvider : Provider {

    fun character(): String
    fun house(): String
    fun city(): String
    fun quote(): String
    fun dragon(): String
}