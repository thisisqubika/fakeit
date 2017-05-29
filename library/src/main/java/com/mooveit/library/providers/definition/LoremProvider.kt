package com.mooveit.library.providers.definition

interface LoremProvider : Provider {

    fun words(): String
    fun supplemental(): String
}