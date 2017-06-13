package com.mooveit.library.providers

import com.mooveit.library.Fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.DateTimeProvider
import java.text.SimpleDateFormat
import java.util.*

class DateTimeProviderImpl : BaseProvider(), DateTimeProvider {

    val date = Date()

    override fun dateFormatter(): String {
        return SimpleDateFormat(getValue("name", { Fakeit.fakeit!!.fetch("date.formats") }), Locale.ENGLISH).format(date)
    }

    override fun timeFormatter(): String {
        return SimpleDateFormat(getValue("name", { Fakeit.fakeit!!.fetch("time.formats") }), Locale.ENGLISH).format(date)
    }

    override fun dateTimeFormatter(): String {
        return SimpleDateFormat(getValue("name", { Fakeit.fakeit!!.fetch("date.format_with_time") }), Locale.ENGLISH).format(date)
    }
}