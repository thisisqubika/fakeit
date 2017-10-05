package com.mooveit.library.providers.definition

interface CoffeeProvider : Provider {

    fun blendName(): String
    fun origin(): String
    fun variety(): String
    fun notes(): String
}