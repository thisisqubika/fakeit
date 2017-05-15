package com.mooveit.library.providers.definition

interface HackerProvider : Provider {

    fun abbreviation(): String
    fun adjective(): String
    fun noun(): String
    fun verb(): String
    fun ingverb(): String
}