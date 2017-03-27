package com.mooveit.library.providers.definition

interface EducatorProvider {

    fun name(): String
    fun secondary(): String
    fun tertiaryType(): String
    fun tertiaryCourseSubject(): String
    fun tertiaryCourseType(): String
}