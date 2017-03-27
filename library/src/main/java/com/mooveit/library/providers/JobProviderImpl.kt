package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.JobProvider

class JobProviderImpl : JobProvider {

    override fun position(): String {
        return fakeit!!.fetch("job.position")
    }

    override fun seniority(): String {
        return fakeit!!.fetch("job.seniority")
    }

    override fun title(): String {
        return fakeit!!.fetch("job.title")
    }

    override fun field(): String {
        return fakeit!!.fetch("job.field")
    }

    override fun keySkill(): String {
        return fakeit!!.fetch("job.key_skills")
    }
}