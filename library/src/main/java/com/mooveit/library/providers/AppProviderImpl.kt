package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.AppProvider

class AppProviderImpl : BaseProvider(), AppProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("app.name") })
    }

    override fun version(): String {
        return getValue("version", { fakeit!!.fetch("app.version") })
    }

    override fun author(): String {
        return getValue("author", { fakeit!!.fetch("app.author") })
    }
}