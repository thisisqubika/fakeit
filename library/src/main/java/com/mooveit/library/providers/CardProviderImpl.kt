package com.mooveit.library.providers

import android.content.res.Resources
import com.mooveit.library.R
import com.mooveit.library.providers.definition.CardProvider
import java.util.*

class CardProviderImpl(resources: Resources) : CardProvider {

    private val names: List<String> = Arrays.asList(*resources.getStringArray(R.array.card_names))
    private val brands: List<String> = Arrays.asList(*resources.getStringArray(R.array.card_brands))
    private val numbers: List<String> = Arrays.asList(*resources.getStringArray(R.array.card_numbers))
    private val types: List<String> = Arrays.asList(*resources.getStringArray(R.array.card_types))
    private val expirationDates: List<String> = Arrays.asList(*resources.getStringArray(R.array.card_expiration_dates))
    private val random = Random()

    override fun name(): String {
        return names[random.nextInt(names.size)]
    }

    override fun brand(): String {
        return brands[random.nextInt(brands.size)]
    }

    override fun number(): String {
        return numbers[random.nextInt(numbers.size)]
    }

    override fun type(): String {
        return types[random.nextInt(types.size)]
    }

    override fun expirationDate(): String {
        return expirationDates[random.nextInt(expirationDates.size)]
    }
}
