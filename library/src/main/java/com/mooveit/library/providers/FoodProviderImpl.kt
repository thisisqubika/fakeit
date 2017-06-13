package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.FoodProvider

class FoodProviderImpl : BaseProvider(), FoodProvider {

    override fun ingredient(): String {
        return getValue("ingredient", { fakeit!!.fetch("food.ingredients") })
    }

    override fun spice(): String {
        return getValue("spice", { fakeit!!.fetch("food.spices") })
    }

    override fun measurement(): String {
        return getValue("measurement", { fakeit!!.fetch("food.measurement_sizes") + " " + fakeit!!.fetch("food.measurements") })
    }
}