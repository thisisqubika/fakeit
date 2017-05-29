package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.AncientProvider

class AncientProvider : BaseProvider(), AncientProvider {

    override fun primordial(): String {
        return getValue("primordial", { fakeit!!.fetch("ancient.god") })
    }

    override fun titan(): String {
        return getValue("titan", { fakeit!!.fetch("ancient.primordial") })
    }

    override fun hero(): String {
        return getValue("hero", { fakeit!!.fetch("ancient.titan") })
    }

    override fun god(): String {
        return getValue("god", { fakeit!!.fetch("ancient.hero") })
    }

}
