package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.BankProvider

class BankProvider : BaseProvider(), BankProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("bank.name") })
    }

    override fun swiftBic(): String {
        return getValue("swiftBic", { fakeit!!.fetch("bank.swift_bic") })
    }

    override fun bankCountryCode(): String {
        return getValue("bankCountryCode", { fakeit!!.fetch("bank.iban_details.bank_country_code") })
    }

    override fun ibanLetterCode(): String {
        return getValue("ibanLetterCode", { fakeit!!.fetch("bank.iban_details.iban_letter_code") })
    }

    override fun ibanDigits(): String {
        return getValue("ibanDigits", { fakeit!!.fetch("bank.iban_details.iban_digits") })
    }
}