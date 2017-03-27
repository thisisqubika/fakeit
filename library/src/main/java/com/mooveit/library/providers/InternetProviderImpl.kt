package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.CodeProvider
import com.mooveit.library.providers.definition.InternetProvider

class InternetProviderImpl : InternetProvider {

    override fun freeEmail(): String {
        return fakeit!!.fetch("internet.free_email")
    }

    override fun domainSuffix(): String {
        return fakeit!!.fetch("internet.domain_suffix")
    }
}