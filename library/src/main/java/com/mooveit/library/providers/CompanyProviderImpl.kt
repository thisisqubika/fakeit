package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.CompanyProvider

class CompanyProviderImpl : CompanyProvider {

    override fun suffix(): String {
        return fakeit!!.fetch("company.suffix")
    }

    override fun buzzwords(): String {
        return fakeit!!.fetch("company.buzzwords")
    }

    override fun bs(): String {
        return fakeit!!.fetch("company.bs")
    }

    override fun name(): String {
        return fakeit!!.fetch("company.name")
    }

    override fun industry(): String {
        return fakeit!!.fetch("company.industry")
    }

    override fun profession(): String {
        return fakeit!!.fetch("company.profession")
    }
}