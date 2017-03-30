package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.AppProvider

class AppProviderImpl : AppProvider {

    override fun name(): String {
        return fakeit!!.fetch("app.name")
    }

    override fun version(): String {
        return fakeit!!.fetch("app.version")
    }

    override fun author(): String {
        return fakeit!!.fetch("app.author")
    }
}