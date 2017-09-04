package com.mooveit.library.providers.base

import com.mooveit.library.Fakeit

open class BaseProvider {

    private val valuesMap = HashMap<String, String>()

    private fun putValue(key: String, value: String) {
        valuesMap.put(key, value)
    }

    fun getValue(key: String, fakeItValue: () -> String): String {
        return if (Fakeit.getUniqueValue()) {
            if (!valuesMap.contains(key)) {
                putValue(key, fakeItValue())
            }
            valuesMap[key]!!
        } else {
            fakeItValue()
        }
    }
}