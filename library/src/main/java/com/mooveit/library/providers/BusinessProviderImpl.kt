package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.BusinessProvider

class BusinessProviderImpl : BaseProvider(), BusinessProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("commerce.product_name.product") })
    }

    override fun type(): String {
        return getValue("type", { fakeit!!.fetch("commerce.department") })
    }

    override fun subType(): String {
        return getValue("subType", { fakeit!!.fetch("commerce.department") })
    }
}

