package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.ArtistProvider

class ArtistProviderImpl : ArtistProvider {

    override fun name(): String {
        return fakeit!!.fetch("artist.names")
    }
}