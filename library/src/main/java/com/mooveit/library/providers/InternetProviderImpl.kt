package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.InternetProvider

class InternetProviderImpl : BaseProvider(), InternetProvider {

    override fun freeEmail(): String {
        return getValue("freeEmail", { fakeit!!.fetch("internet.free_email") })
    }

    override fun domainSuffix(): String {
        return getValue("domainSuffix", { fakeit!!.fetch("internet.domain_suffix") })
    }
}