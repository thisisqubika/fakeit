package com.mooveit.library.providers

import com.mooveit.library.Fakeit
import com.mooveit.library.providers.definition.DateTimeProvider
import java.text.SimpleDateFormat
import java.util.*

class DateTimeProviderImpl : DateTimeProvider {

    val date = Date()

    override fun dateFormatter(): String {
        return SimpleDateFormat(Fakeit.fakeit!!.fetch("date.formats")).format(date)
    }

    override fun timeFormatter(): String {
        return SimpleDateFormat(Fakeit.fakeit!!.fetch("time.formats")).format(date)
    }

    override fun dateTimeFormatter(): String {
        return SimpleDateFormat(Fakeit.fakeit!!.fetch("date.format_with_time")).format(date)
    }
}