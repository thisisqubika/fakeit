package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.AddressProvider

class AddressProviderImpl : AddressProvider {

    override fun city(): String {
        return fakeit!!.fetch("address.city")
    }

    override fun streetAddress(): String {
        return fakeit!!.fetch("address.street_address")
    }

    override fun buildingNumber(): String {
        return fakeit!!.fetch("address.secondary_address")
    }

    override fun zipCode(): String {
        return fakeit!!.fetch("address.zip_code")
    }

    override fun state(): String {
        return fakeit!!.fetch("address.state")
    }

    override fun stateAbbreviation(): String {
        return fakeit!!.fetch("address.state_abbr")
    }
}