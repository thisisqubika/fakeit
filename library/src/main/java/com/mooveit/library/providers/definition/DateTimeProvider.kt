package com.mooveit.library.providers.definition

interface DateTimeProvider : Provider {

    fun dateFormatter(): String
    fun timeFormatter(): String
    fun dateTimeFormatter(): String
}