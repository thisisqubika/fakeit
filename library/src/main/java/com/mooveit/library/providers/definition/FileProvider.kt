package com.mooveit.library.providers.definition

interface FileProvider {

    fun extension(): String
    fun mimeType(): String
}