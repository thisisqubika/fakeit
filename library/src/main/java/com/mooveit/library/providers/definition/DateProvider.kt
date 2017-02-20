package com.mooveit.library.providers.definition

import java.util.*

interface DateProvider : Provider {

    fun date(): String
    fun dateBetweenRanges(date: Calendar, date2: Calendar): String
    fun dateInTheFuture(date: Calendar): String
    fun dateInTheFuture(days: Int): String
    fun dateInThePast(date: Calendar): String
    fun dateInThePast(days: Int): String
}
