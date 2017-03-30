package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.EducatorProvider

class EducatorProviderImpl : EducatorProvider {

    override fun name(): String {
        return fakeit!!.fetch("educator.name")
    }

    override fun secondary(): String {
        return fakeit!!.fetch("educator.secondary")
    }

    override fun tertiaryType(): String {
        return fakeit!!.fetch("educator.tertiary.type")
    }

    override fun tertiaryCourseSubject(): String {
        return fakeit!!.fetch("educator.tertiary.course.subject")
    }

    override fun tertiaryCourseType(): String {
        return fakeit!!.fetch("educator.tertiary.course.type")
    }
}