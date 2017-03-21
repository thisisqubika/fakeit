package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.CatProvider

class CatProviderImpl: CatProvider {

    override fun name(): String {
        return fakeit!!.fetch("cat.name")
    }

    override fun breed(): String {
        return fakeit!!.fetch("cat.breed")
    }

    override fun registry(): String {
        return fakeit!!.fetch("cat.registry")
    }
}