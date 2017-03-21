package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.DemographicProvider

class DemographicProviderImpl : DemographicProvider {

    override fun race(): String {
        return fakeit!!.fetch("demographic.race")
    }

    override fun educationalAttainment(): String {
        return fakeit!!.fetch("demographic.educational_attainment")
    }

    override fun demonym(): String {
        return fakeit!!.fetch("demographic.demonym")
    }

    override fun maritalStatus(): String {
        return fakeit!!.fetch("demographic.marital_status")
    }

    override fun sex(): String {
        return fakeit!!.fetch("demographic.sex")
    }

}