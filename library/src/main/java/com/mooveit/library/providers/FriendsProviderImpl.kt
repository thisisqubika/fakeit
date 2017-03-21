package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.FriendsProvider

class FriendsProviderImpl: FriendsProvider {

    override fun character(): String {
        return fakeit!!.fetch("friends.characters")
    }

    override fun location(): String {
        return fakeit!!.fetch("friends.locations")
    }

    override fun quote(): String {
        return fakeit!!.fetch("friends.quotes")
    }
}

