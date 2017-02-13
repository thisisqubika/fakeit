package com.mooveit.library.providers

import android.content.res.Resources
import com.mooveit.library.R
import com.mooveit.library.providers.definition.AddressProvider
import java.util.*

class AddressProviderImpl(resources: Resources) : AddressProvider {

    private val cities = Arrays.asList(*resources.getStringArray(R.array.cities))
    private val streetAddresses = Arrays.asList(*resources.getStringArray(R.array.street_addresses))
    private val buildingNumbers = Arrays.asList(*resources.getStringArray(R.array.building_numbers))
    private val zipCodes = Arrays.asList(*resources.getStringArray(R.array.zip_codes))
    private val states = Arrays.asList(*resources.getStringArray(R.array.states))
    private val statesAbbreviations = Arrays.asList(*resources.getStringArray(R.array.states_abbreviations))
    private val latitudes = Arrays.asList(*resources.getStringArray(R.array.latitudes))
    private val longitudes = Arrays.asList(*resources.getStringArray(R.array.longitudes))
    private val resourcesList = listOf(cities, streetAddresses, buildingNumbers,
            zipCodes, states, statesAbbreviations, latitudes, longitudes)
    private val random = Random()
    private var index = -1

    override fun initRandomAddress() {
        val size = states.size
        if (resourcesList.filter { list -> list.size != size }.isEmpty()) {
            index = random.nextInt(size)
        } else {
            throw IllegalArgumentException("Address resources must have the same array length for this feature to work")
        }
    }

    override fun city(): String {
        return getData(cities)
    }

    override fun streetAddress(): String {
        return getData(streetAddresses)
    }

    override fun buildingNumber(): String {
        return getData(buildingNumbers)
    }

    override fun zipCode(): String {
        return getData(zipCodes)
    }

    override fun state(): String {
        return getData(states)
    }

    override fun stateAbbreviation(): String {
        return getData(latitudes)
    }

    override fun latitude(): String {
        return getData(latitudes)
    }

    override fun longitude(): String {
        return getData(longitudes)
    }

    fun getData(array: List<String>): String {
        if (index == -1) {
            return array[random.nextInt(array.size)]
        } else {
            return array[index]
        }
    }
}