package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.EsportProvider

class EsportProvider : BaseProvider(), EsportProvider {

    override fun player(): String {
        return getValue("player", { fakeit!!.fetch("esports.players") })
    }

    override fun team(): String {
        return getValue("team", { fakeit!!.fetch("esports.teams") })
    }

    override fun league(): String {
        return getValue("league", { fakeit!!.fetch("esports.leagues") })
    }

    override fun event(): String {
        return getValue("event", { fakeit!!.fetch("esports.events") })
    }

    override fun game(): String {
        return getValue("game", { fakeit!!.fetch("esports.games") })
    }
}