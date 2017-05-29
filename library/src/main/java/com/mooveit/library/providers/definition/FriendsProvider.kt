package com.mooveit.library.providers.definition

interface FriendsProvider : Provider {

    fun character(): String
    fun location(): String
    fun quote(): String
}