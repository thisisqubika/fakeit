package com.mooveit.library

import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

val defaultLanguage = "en"
val numeralAndBracesRegEx = "#\\{[\\.a-zA-Z_-]+\\}"
val numeralRegEx = "[#]+"

fun Yaml.getValues(language: String, javaClass: Class<*>): LinkedHashMap<String, LinkedHashMap<String, String>> {
    val inputStream = javaClass.classLoader.getResourceAsStream("res/raw/".plus(language).plus(".yml"))
    return if (inputStream != null) {
        val yamlValues = this.load(inputStream) as Map<*, *>
        val localeValues = yamlValues[language] as Map<*, *>
        localeValues["faker"] as LinkedHashMap<String, LinkedHashMap<String, String>>
    } else {
        throw Exception("Locale $language does not exist")
    }
}

fun fetchNumerals(numeral: String): String {
    val stringBuffer = StringBuffer()
    return matchAndReplace(numeral, stringBuffer, "#",
            { matcher -> matcher.appendReplacement(stringBuffer, Random().nextInt(10).toString()) })
}

fun matchAndReplace(stringToMatch: String, stringBuffer: StringBuffer, regExp: String, method: (Matcher) -> Matcher): String {
    val matcher = Pattern.compile(regExp).matcher(stringToMatch)
    while (matcher.find()) {
        method(matcher)
    }
    matcher.appendTail(stringBuffer)
    return stringBuffer.toString()
}

fun ArrayList<String>.getRandomString(): String = this[Random().nextInt(this.size)]

fun getResourceNotFound(key: String): String = "Resource not found $key"