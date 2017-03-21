package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.GameOfThronesProvider

class GameOfThronesProviderImpl : GameOfThronesProvider {

    override fun character(): String {
        return fakeit!!.fetch("game_of_thrones.characters")
    }

    override fun house(): String {
        return fakeit!!.fetch("game_of_thrones.houses")
    }

    override fun city(): String {
        return fakeit!!.fetch("game_of_thrones.cities")
    }

    override fun quote(): String {
        return fakeit!!.fetch("game_of_thrones.quotes")
    }

    override fun dragon(): String {
        return fakeit!!.fetch("game_of_thrones.dragons")
    }
}