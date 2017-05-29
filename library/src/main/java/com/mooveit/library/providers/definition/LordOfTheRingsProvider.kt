package com.mooveit.library.providers.definition

interface LordOfTheRingsProvider : Provider {

    fun character(): String
    fun location(): String
}