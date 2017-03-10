package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.CardProvider

class CardProviderImpl : CardProvider {

    override fun name(): String {
        return fakeit!!.fetch("name.name")
    }

    override fun brand(): String {
        return fakeit!!.fetch("business.credit_card_types")
    }

    override fun number(): String {
        return fakeit!!.fetch("credit_card.visa")
    }

    override fun type(): String {
        return fakeit!!.fetch("business.credit_card_types")
    }

    override fun expirationDate(): String {
        return fakeit!!.fetch("business.credit_card_expiry_dates")
    }
}
