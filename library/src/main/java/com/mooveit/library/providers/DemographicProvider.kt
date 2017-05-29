package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.DemographicProvider

class DemographicProvider : BaseProvider(), DemographicProvider {

    override fun race(): String {
        return getValue("race", { fakeit!!.fetch("demographic.race") })
    }

    override fun educationalAttainment(): String {
        return getValue("educationalAttainment", { fakeit!!.fetch("demographic.educational_attainment") })
    }

    override fun demonym(): String {
        return getValue("demonym", { fakeit!!.fetch("demographic.demonym") })
    }

    override fun maritalStatus(): String {
        return getValue("maritalStatus", { fakeit!!.fetch("demographic.marital_status") })
    }

    override fun sex(): String {
        return getValue("sex", { fakeit!!.fetch("demographic.sex") })
    }
}