package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.HipsterProvider

class HipsterProviderImpl : HipsterProvider {

    override fun words(): String {
        return fakeit!!.fetch("hipster.words")
    }
}