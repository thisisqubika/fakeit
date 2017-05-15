package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.CompassProvider

class CompassProvider : BaseProvider(), CompassProvider {

    override fun cardinal(): String {
        return getValue("cardinal", { fakeit!!.fetch("compass.cardinal.word") })
    }

    override fun ordinal(): String {
        return getValue("ordinal", { fakeit!!.fetch("compass.ordinal.word") })
    }

    override fun half_wind(): String {
        return getValue("half_wind", { fakeit!!.fetch("compass.half-wind.word") })
    }

    override fun quarter_wind(): String {
        return getValue("quarter_wind", { fakeit!!.fetch("compass.quarter-wind.word") })
    }

    override fun direction(): String {
        return getValue("direction", { fakeit!!.fetch("compass.direction") })
    }

    override fun abbreviation(): String {
        return getValue("abbreviation", { fakeit!!.fetch("compass.abbreviation") })
    }

    override fun azimuth(): String {
        return getValue("azimuth", { fakeit!!.fetch("compass.azimuth") })
    }

    override fun cardinal_abbreviation(): String {
        return getValue("cardinal_abbreviation", { fakeit!!.fetch("compass.cardinal.abbreviation") })
    }

    override fun ordinal_abbreviation(): String {
        return getValue("ordinal_abbreviation", { fakeit!!.fetch("compass.cardinal.abbreviation") })
    }

    override fun half_wind_abbreviation(): String {
        return getValue("half_wind_abbreviation", { fakeit!!.fetch("compass.half-wind.abbreviation") })
    }

    override fun quarter_wind_abbreviation(): String {
        return getValue("quarter_wind_abbreviation", { fakeit!!.fetch("compass.quarter-wind.abbreviation") })
    }

    override fun cardinal_azimuth(): String {
        return getValue("cardinal_azimuth", { fakeit!!.fetch("compass.cardinal.azimuth") })
    }

    override fun ordinal_azimuth(): String {
        return getValue("ordinal_azimuth", { fakeit!!.fetch("compass.ordinal.azimuth") })
    }

    override fun half_wind_azimuth(): String {
        return getValue("half_wind_azimuth", { fakeit!!.fetch("compass.half-wind.azimuth") })
    }

    override fun quarter_wind_azimuth(): String {
        return getValue("quarter_wind_azimuth", { fakeit!!.fetch("compass.quarter-wind.azimuth") })
    }
}