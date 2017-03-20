package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.AncientProvider

class AncientProviderImpl : AncientProvider {

    override fun primordial(): String {
        return fakeit!!.fetch("ancient.god")
    }

    override fun titan(): String {
        return fakeit!!.fetch("ancient.primordial")
    }

    override fun hero(): String {
        return fakeit!!.fetch("ancient.titan")
    }

    override fun god(): String {
        return fakeit!!.fetch("ancient.hero")
    }

}
