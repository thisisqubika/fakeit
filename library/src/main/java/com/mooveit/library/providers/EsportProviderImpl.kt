package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.EsportProvider

class EsportProviderImpl : EsportProvider {

    override fun player(): String {
        return fakeit!!.fetch("esports.players")
    }

    override fun team(): String {
        return fakeit!!.fetch("esports.teams")
    }

    override fun league(): String {
        return fakeit!!.fetch("esports.leagues")
    }

    override fun event(): String {
        return fakeit!!.fetch("esports.events")
    }

    override fun game(): String {
        return fakeit!!.fetch("esports.games")
    }
}