package com.mooveit.library.providers.definition

interface BookProvider {

    fun title(): String
    fun author(): String
    fun publisher(): String
    fun genre(): String
}