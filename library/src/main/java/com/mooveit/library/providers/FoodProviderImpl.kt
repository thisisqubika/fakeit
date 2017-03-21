package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.FoodProvider

class FoodProviderImpl : FoodProvider {

    override fun ingredient(): String {
        return fakeit!!.fetch("food.ingredients")
    }

    override fun spice(): String {
        return fakeit!!.fetch("food.spices")
    }

    override fun measurement(): String {
        return fakeit!!.fetch("food.measurement_sizes") + " " + fakeit!!.fetch("food.measurements")
    }
}