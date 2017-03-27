package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.PhoneNumberProvider

class PhoneNumberProviderImpl : PhoneNumberProvider {

    override fun formats(): String {
        return fakeit!!.fetch("phone_number.formats")
    }
}