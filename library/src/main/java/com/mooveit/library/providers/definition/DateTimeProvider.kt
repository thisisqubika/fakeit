package com.mooveit.library.providers.definition

interface DateTimeProvider {

    fun dateFormatter(): String
    fun timeFormatter(): String
    fun dateTimeFormatter(): String
}