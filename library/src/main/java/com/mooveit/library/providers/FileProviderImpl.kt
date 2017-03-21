package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.FileProvider

class FileProviderImpl : FileProvider {

    override fun extension(): String {
        return fakeit!!.fetch("file.extension")
    }

    override fun mimeType(): String {
        return fakeit!!.fetch("file.mime_type")
    }
}