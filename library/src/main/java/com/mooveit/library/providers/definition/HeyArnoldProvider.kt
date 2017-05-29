package com.mooveit.library.providers.definition

interface HeyArnoldProvider : Provider {

    fun character(): String
    fun location(): String
    fun quote(): String
}