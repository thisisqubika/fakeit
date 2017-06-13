package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.LoremProvider

class LoremProviderImpl : BaseProvider(), LoremProvider {

    override fun words(): String {
        return getValue("words", { fakeit!!.fetch("lorem.words") })
    }

    override fun supplemental(): String {
        return getValue("supplemental", { fakeit!!.fetch("lorem.supplemental") })
    }
}