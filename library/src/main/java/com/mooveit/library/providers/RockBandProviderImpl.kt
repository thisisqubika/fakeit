package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.RockBandProvider

class RockBandProviderImpl : RockBandProvider {

    override fun name(): String {
        return fakeit!!.fetch("rock_band.name")
    }
}