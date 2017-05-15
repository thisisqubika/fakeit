package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.FriendsProvider

class FriendsProvider : BaseProvider(), FriendsProvider {

    override fun character(): String {
        return getValue("character", { fakeit!!.fetch("friends.characters") })
    }

    override fun location(): String {
        return getValue("location", { fakeit!!.fetch("friends.locations") })
    }

    override fun quote(): String {
        return getValue("quote", { fakeit!!.fetch("friends.quotes") })
    }
}

