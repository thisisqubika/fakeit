package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.CodeProvider

class CodeProviderImpl : CodeProvider {
    
    override fun asin(): String {
        return fakeit!!.fetch("code.asin")
    }
}