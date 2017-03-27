package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.LoremProvider

class LoremProviderImpl : LoremProvider {

    override fun words(): String {
        return fakeit!!.fetch("lorem.words")
    }

    override fun supplemental(): String {
        return fakeit!!.fetch("lorem.supplemental")
    }
}