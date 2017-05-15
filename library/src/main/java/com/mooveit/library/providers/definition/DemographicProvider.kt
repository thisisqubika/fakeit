package com.mooveit.library.providers.definition

interface DemographicProvider : Provider {

    fun race(): String
    fun educationalAttainment(): String
    fun demonym(): String
    fun maritalStatus(): String
    fun sex(): String
}

