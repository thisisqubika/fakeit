package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.BookProvider

class BookProviderImpl : BaseProvider(), BookProvider {

    override fun title(): String {
        return getValue("title", { fakeit!!.fetch("book.title") })
    }

    override fun author(): String {
        return getValue("author", { fakeit!!.fetch("book.author") })
    }

    override fun publisher(): String {
        return getValue("publisher", { fakeit!!.fetch("book.publisher") })
    }

    override fun genre(): String {
        return getValue("genre", { fakeit!!.fetch("book.genre") })
    }
}