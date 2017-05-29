package com.mooveit.library.providers.definition

interface CompassProvider : Provider {

    fun cardinal(): String
    fun ordinal(): String
    fun half_wind(): String
    fun quarter_wind(): String
    fun direction(): String
    fun abbreviation(): String
    fun azimuth(): String
    fun cardinal_abbreviation(): String
    fun ordinal_abbreviation(): String
    fun half_wind_abbreviation(): String
    fun quarter_wind_abbreviation(): String
    fun cardinal_azimuth(): String
    fun ordinal_azimuth(): String
    fun half_wind_azimuth(): String
    fun quarter_wind_azimuth(): String
}