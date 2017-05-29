package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.CatProvider

class CatProvider : BaseProvider(), CatProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("cat.name") })
    }

    override fun breed(): String {
        return getValue("name", { fakeit!!.fetch("cat.breed") })
    }

    override fun registry(): String {
        return getValue("name", { fakeit!!.fetch("cat.registry") })
    }
}