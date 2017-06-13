package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.JobProvider

class JobProviderImpl : BaseProvider(), JobProvider {

    override fun position(): String {
        return getValue("position", { fakeit!!.fetch("job.position") })
    }

    override fun seniority(): String {
        return getValue("seniority", { fakeit!!.fetch("job.seniority") })
    }

    override fun title(): String {
        return getValue("title", { fakeit!!.fetch("job.title") })
    }

    override fun field(): String {
        return getValue("field", { fakeit!!.fetch("job.field") })
    }

    override fun keySkill(): String {
        return getValue("keySkill", { fakeit!!.fetch("job.key_skills") })
    }
}