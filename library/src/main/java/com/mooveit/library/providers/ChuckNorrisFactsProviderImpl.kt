package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.ChuckNorrisFactsProvider

class ChuckNorrisFactsProviderImpl : ChuckNorrisFactsProvider {

    override fun fact(): String {
        return fakeit!!.fetch("chuck_norris.fact")
    }
}