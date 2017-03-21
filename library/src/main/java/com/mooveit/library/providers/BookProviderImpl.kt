package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.BookProvider

class BookProviderImpl : BookProvider {

    override fun title(): String {
        return fakeit!!.fetch("book.title")
    }

    override fun author(): String {
        return fakeit!!.fetch("book.author")
    }

    override fun publisher(): String {
        return fakeit!!.fetch("book.publisher")
    }

    override fun genre(): String {
        return fakeit!!.fetch("book.genre")
    }
}