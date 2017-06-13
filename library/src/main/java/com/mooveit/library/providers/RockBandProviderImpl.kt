package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.RockBandProvider

class RockBandProviderImpl : BaseProvider(), RockBandProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("rock_band.name") })
    }
}