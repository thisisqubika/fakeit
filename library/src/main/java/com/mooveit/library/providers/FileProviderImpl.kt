package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.FileProvider

class FileProviderImpl : BaseProvider(), FileProvider {

    override fun extension(): String {
        return getValue("extension", { fakeit!!.fetch("file.extension") })
    }

    override fun mimeType(): String {
        return getValue("mimeType", { fakeit!!.fetch("file.mime_type") })
    }
}