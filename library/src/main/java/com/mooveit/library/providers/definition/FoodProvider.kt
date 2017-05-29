package com.mooveit.library.providers.definition

interface FoodProvider : Provider {

    fun ingredient(): String
    fun spice(): String
    fun measurement(): String
}
