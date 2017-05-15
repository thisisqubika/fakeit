package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.NameProvider

class NameProvider : BaseProvider(), NameProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("name.name") })
    }

    override fun nameWithMiddle(): String {
        return getValue("nameWithMiddle", { fakeit!!.fetch("name.name_with_middle") })
    }

    override fun firstName(): String {
        return getValue("firstName", { fakeit!!.fetch("name.first_name") })
    }

    override fun lastName(): String {
        return getValue("lastName", { fakeit!!.fetch("name.last_name") })
    }

    override fun prefix(): String {
        return getValue("prefix", { fakeit!!.fetch("name.prefix") })
    }

    override fun suffix(): String {
        return getValue("suffix", { fakeit!!.fetch("name.suffix") })
    }

    override fun title(): String {
        return getValue("title", { fakeit!!.fetch("name.title.job") })
    }
}