package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.HipsterProvider

class HipsterProviderImpl : BaseProvider(), HipsterProvider {

    override fun words(): String {
        return getValue("words", { fakeit!!.fetch("hipster.words") })
    }
}