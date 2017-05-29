package com.mooveit.library.providers.definition

interface HarryPotterProvider : Provider {

    fun character(): String
    fun location(): String
    fun quote(): String
    fun book(): String
}