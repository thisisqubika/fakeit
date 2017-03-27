package com.mooveit.library.providers.definition

interface BankProvider {

    fun name(): String
    fun swiftBic(): String
    fun bankCountryCode(): String
    fun ibanLetterCode(): String
    fun ibanDigits(): String
}