package com.mooveit.library.providers.definition

interface JobProvider : Provider {

    fun field(): String
    fun seniority(): String
    fun position(): String
    fun title(): String
    fun keySkill(): String
}