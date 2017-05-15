package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.GameOfThronesProvider

class GameOfThronesProvider : BaseProvider(), GameOfThronesProvider {

    override fun character(): String {
        return getValue("character", { fakeit!!.fetch("game_of_thrones.characters") })
    }

    override fun house(): String {
        return getValue("house", { fakeit!!.fetch("game_of_thrones.houses") })
    }

    override fun city(): String {
        return getValue("city", { fakeit!!.fetch("game_of_thrones.cities") })
    }

    override fun quote(): String {
        return getValue("quote", { fakeit!!.fetch("game_of_thrones.quotes") })
    }

    override fun dragon(): String {
        return getValue("dragon", { fakeit!!.fetch("game_of_thrones.dragons") })
    }
}