package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.CompassProvider

class CompassProviderImpl : CompassProvider {

    override fun cardinal(): String {
        return fakeit!!.fetch("compass.cardinal.word")
    }

    override fun ordinal(): String {
        return fakeit!!.fetch("compass.ordinal.word")
    }

    override fun half_wind(): String {
        return fakeit!!.fetch("compass.half-wind.word")
    }

    override fun quarter_wind(): String {
        return fakeit!!.fetch("compass.quarter-wind.word")
    }

    override fun direction(): String {
        return fakeit!!.fetch("compass.direction")
    }

    override fun abbreviation(): String {
        return fakeit!!.fetch("compass.abbreviation")
    }

    override fun azimuth(): String {
        return fakeit!!.fetch("compass.azimuth")
    }

    override fun cardinal_abbreviation(): String {
        return fakeit!!.fetch("compass.cardinal.abbreviation")
    }

    override fun ordinal_abbreviation(): String {
        return fakeit!!.fetch("compass.cardinal.abbreviation")
    }

    override fun half_wind_abbreviation(): String {
        return fakeit!!.fetch("compass.half-wind.abbreviation")
    }

    override fun quarter_wind_abbreviation(): String {
        return fakeit!!.fetch("compass.quarter-wind.abbreviation")
    }

    override fun cardinal_azimuth(): String {
        return fakeit!!.fetch("compass.cardinal.azimuth")
    }

    override fun ordinal_azimuth(): String {
        return fakeit!!.fetch("compass.ordinal.azimuth")
    }

    override fun half_wind_azimuth(): String {
        return fakeit!!.fetch("compass.half-wind.azimuth")
    }

    override fun quarter_wind_azimuth(): String {
        return fakeit!!.fetch("compass.quarter-wind.azimuth")
    }
}