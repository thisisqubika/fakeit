package com.mooveit.library.providers.definition

interface CompanyProvider : Provider {

    fun suffix(): String
    fun buzzwords(): String
    fun bs(): String
    fun name(): String
    fun industry(): String
    fun profession(): String
}