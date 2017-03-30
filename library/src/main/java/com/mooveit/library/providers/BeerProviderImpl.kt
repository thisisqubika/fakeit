package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.BeerProvider
import java.util.*

class BeerProviderImpl : BeerProvider {

    val rand = Random()

    override fun name(): String {
        return fakeit!!.fetch("beer.name")
    }

    override fun style(): String {
        return fakeit!!.fetch("beer.style")
    }

    override fun hop(): String {
        return fakeit!!.fetch("beer.hop")
    }

    override fun yeast(): String {
        return fakeit!!.fetch("beer.yeast")
    }

    override fun malts(): String {
        return fakeit!!.fetch("beer.malt")
    }

    override fun ibu(): String {
        val randomIbu = rand.nextInt((100 - 10) + 1) + 10
        return randomIbu.toString()
    }

    override fun alcohol(): String {
        val randomAlcohol = rand.nextFloat() * (10.0 - 2.0) + 2.0
        return randomAlcohol.toString()
    }

    override fun blg(): String {
        val randomBlg = rand.nextFloat() * (20.0 - 5.0) + 5.0
        return randomBlg.toString()
    }
}