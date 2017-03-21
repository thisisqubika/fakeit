package com.mooveit.library.providers.definition

interface DemographicProvider {

    fun race(): String
    fun educationalAttainment(): String
    fun demonym(): String
    fun maritalStatus(): String
    fun sex(): String
}

