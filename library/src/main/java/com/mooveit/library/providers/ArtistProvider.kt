package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.ArtistProvider

class ArtistProvider : BaseProvider(), ArtistProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("artist.names") })
    }
}