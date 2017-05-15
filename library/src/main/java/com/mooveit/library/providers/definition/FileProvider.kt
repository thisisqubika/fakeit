package com.mooveit.library.providers.definition

interface FileProvider : Provider {

    fun extension(): String
    fun mimeType(): String
}