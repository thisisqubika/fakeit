package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.CardProvider

class CardProvider : BaseProvider(), CardProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("name.name") })
    }

    override fun brand(): String {
        return getValue("name", { fakeit!!.fetch("business.credit_card_types") })
    }

    override fun number(): String {
        return getValue("name", { fakeit!!.fetch("credit_card.visa") })
    }

    override fun type(): String {
        return getValue("name", { fakeit!!.fetch("business.credit_card_types") })
    }

    override fun expirationDate(): String {
        return getValue("name", { fakeit!!.fetch("business.credit_card_expiry_dates") })
    }
}
