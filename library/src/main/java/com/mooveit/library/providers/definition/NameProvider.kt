package com.mooveit.library.providers.definition

interface NameProvider : Provider {

    fun name(): String
    fun nameWithMiddle(): String
    fun firstName(): String
    fun lastName(): String
    fun prefix(): String
    fun suffix(): String
    fun title(): String
}
