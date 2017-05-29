package com.mooveit.library.providers.definition

interface EducatorProvider : Provider {

    fun name(): String
    fun secondary(): String
    fun tertiaryType(): String
    fun tertiaryCourseSubject(): String
    fun tertiaryCourseType(): String
}