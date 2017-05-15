package com.mooveit.library.providers.definition

interface BookProvider : Provider {

    fun title(): String
    fun author(): String
    fun publisher(): String
    fun genre(): String
}