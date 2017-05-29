package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.ChuckNorrisFactsProvider

class ChuckNorrisFactsProviderImpl : BaseProvider(), ChuckNorrisFactsProvider {

    override fun fact(): String {
        return getValue("fact", { fakeit!!.fetch("chuck_norris.fact") })
    }
}