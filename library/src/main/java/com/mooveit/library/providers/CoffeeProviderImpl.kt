package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.CoffeeProvider

class CoffeeProviderImpl : BaseProvider(), CoffeeProvider {

    override fun blendName(): String = getValue("blend_name", { fakeit!!.fetch("coffee.blend_name") })

    override fun origin(): String {
        val country = getValue("country", { fakeit!!.fetch("coffee.country") })
        val country_formatted = country.replace(" ", "_").toLowerCase()
        return country + ", " + getValue("regions", { fakeit!!.fetch("coffee.regions.$country_formatted") })
    }

    override fun variety(): String = getValue("variety", { fakeit!!.fetch("coffee.variety") })

    override fun notes(): String = getValue("notes", { fakeit!!.fetch("coffee.notes") })
}