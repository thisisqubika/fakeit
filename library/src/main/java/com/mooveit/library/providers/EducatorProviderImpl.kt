package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.EducatorProvider

class EducatorProviderImpl : BaseProvider(), EducatorProvider {

    override fun name(): String {
        return getValue("name", { fakeit!!.fetch("educator.name") })
    }

    override fun secondary(): String {
        return getValue("secondary", { fakeit!!.fetch("educator.secondary") })
    }

    override fun tertiaryType(): String {
        return getValue("tertiaryType", { fakeit!!.fetch("educator.tertiary.type") })
    }

    override fun tertiaryCourseSubject(): String {
        return getValue("tertiaryCourseSubject", { fakeit!!.fetch("educator.tertiary.course.subject") })
    }

    override fun tertiaryCourseType(): String {
        return getValue("tertiaryCourseType", { fakeit!!.fetch("educator.tertiary.course.type") })
    }
}