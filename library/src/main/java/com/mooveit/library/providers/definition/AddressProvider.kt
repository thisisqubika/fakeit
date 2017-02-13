package com.mooveit.library.providers.definition

interface AddressProvider : Provider {

    fun initRandomAddress()
    fun city(): String
    fun streetAddress(): String
    fun buildingNumber(): String
    fun zipCode(): String
    fun state(): String
    fun stateAbbreviation(): String
    fun latitude(): String
    fun longitude(): String
}