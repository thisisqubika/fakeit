package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.AddressProvider

class AddressProviderImpl : BaseProvider(), AddressProvider {

    override fun city(): String {
        return getValue("city", { fakeit!!.fetch("address.city") })
    }

    override fun streetAddress(): String {
        return getValue("streetAddress", { fakeit!!.fetch("address.street_address") })
    }

    override fun buildingNumber(): String {
        return getValue("buildingNumber", { fakeit!!.fetch("address.secondary_address") })
    }

    override fun zipCode(): String {
        return getValue("zipCode", { fakeit!!.fetch("address.zip_code") })
    }

    override fun state(): String {
        return getValue("state", { fakeit!!.fetch("address.state") })
    }

    override fun stateAbbreviation(): String {
        return getValue("stateAbbreviation", { fakeit!!.fetch("address.state_abbr") })
    }
}