package com.mooveit.library.providers

import android.content.res.Resources
import com.mooveit.library.R
import com.mooveit.library.providers.definition.DateProvider
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class DateProviderImpl(resources: Resources) : DateProvider {

    private val formatter = SimpleDateFormat(resources.getString(R.string.format))
    private val minYear = 1950
    private val maxYear = 2050

    fun randBetween(start: Int, end: Int): Int {
        return start + Math.round(Math.random() * (end - start)).toInt()
    }

    override fun date(): String {
        val gc = GregorianCalendar()

        val year = randBetween(minYear, maxYear)
        val month = randBetween(0, 11)
        gc.set(year, month, 1)
        val daysInMonth = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_MONTH))
        gc.set(year, month, daysInMonth)

        return formatter.format(gc.time)
    }

    override fun dateBetweenRanges(date: Calendar, date2: Calendar): String {
        setDateData(date, date2)
        return formatter.format(date.time)
    }

    override fun dateInTheFuture(date: Calendar): String {
        val generatedDate = Calendar.getInstance()
        setDateData(generatedDate, date)
        return formatter.format(generatedDate.time)
    }

    override fun dateInTheFuture(days: Int): String {
        val futureDate = Calendar.getInstance()
        futureDate.add(Calendar.DATE, randBetween(0, days))
        return formatter.format(futureDate.time)
    }

    override fun dateInThePast(date: Calendar): String {
        return dateInThePast(daysBetween(date, Calendar.getInstance()))
    }

    override fun dateInThePast(days: Int): String {
        val pastDate = Calendar.getInstance()
        pastDate.add(Calendar.DATE, randBetween(0, days) * -1)
        return formatter.format(pastDate.time)
    }

    fun setDateData(date: Calendar, date2: Calendar) {
        val year = randBetween(date.get(Calendar.YEAR), date2.get(Calendar.YEAR))
        val month = randBetween(date.get(Calendar.MONTH), date2.get(Calendar.MONTH))
        val daysInMonth = randBetween(date.get(Calendar.DAY_OF_MONTH), date2.get(Calendar.DAY_OF_MONTH))
        date.set(year, month, daysInMonth)
    }

    fun daysBetween(startDate: Calendar, endDate: Calendar): Int {
        val end = endDate.timeInMillis
        val start = startDate.timeInMillis
        val diff = Math.abs(end - start)
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toInt()
    }
}
