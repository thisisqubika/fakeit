package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.NameProvider

class NameProviderImpl : NameProvider {

    override fun name(): String {
        return fakeit!!.fetch("name.name")
    }

    override fun nameWithMiddle(): String {
        return fakeit!!.fetch("name.name_with_middle")
    }

    override fun firstName(): String {
        return fakeit!!.fetch("name.first_name")
    }

    override fun lastName(): String {
        return fakeit!!.fetch("name.last_name")
    }

    override fun prefix(): String {
        return fakeit!!.fetch("name.prefix")
    }

    override fun suffix(): String {
        return fakeit!!.fetch("name.suffix")
    }

    override fun title(): String {
        return fakeit!!.fetch("name.title.job")
    }
}