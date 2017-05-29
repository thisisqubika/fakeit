package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.CompanyProvider

class CompanyProvider : BaseProvider(), CompanyProvider {

    override fun suffix(): String {
        return getValue("suffix", { fakeit!!.fetch("company.suffix") })
    }

    override fun buzzwords(): String {
        return getValue("buzzwords", { fakeit!!.fetch("company.buzzwords") })
    }

    override fun bs(): String {
        return getValue("bs", { fakeit!!.fetch("company.bs") })
    }

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("company.name") })
    }

    override fun industry(): String {
        return getValue("industry", { fakeit!!.fetch("company.industry") })
    }

    override fun profession(): String {
        return getValue("profession", { fakeit!!.fetch("company.profession") })
    }
}