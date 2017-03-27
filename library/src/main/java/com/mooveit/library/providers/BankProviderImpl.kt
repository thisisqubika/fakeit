package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.BankProvider

class BankProviderImpl : BankProvider {

    override fun name(): String {
        return fakeit!!.fetch("bank.title")
    }

    override fun swiftBic(): String {
        return fakeit!!.fetch("bank.swift_bic")
    }

    override fun bankCountryCode(): String {
        return fakeit!!.fetch("bank.iban_details.country_code")
    }

    override fun ibanLetterCode(): String {
        return fakeit!!.fetch("bank.iban_details..iban_letter_code")
    }

    override fun ibanDigits(): String {
        return fakeit!!.fetch("bank.iban_details.iban_digits")
    }
}