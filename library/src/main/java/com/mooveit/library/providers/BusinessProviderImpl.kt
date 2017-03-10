package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.BusinessProvider

class BusinessProviderImpl : BusinessProvider {

    override fun name(): String {
        return fakeit!!.fetch("commerce.department")
    }

    override fun type(): String {
        return fakeit!!.fetch("commerce.department")
    }

    override fun subType(): String {
        return fakeit!!.fetch("commerce.department")
    }
}

