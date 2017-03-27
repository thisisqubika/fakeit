package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.definition.MusicProvider
import java.util.*

class MusicProviderImpl : MusicProvider {

    val keys = listOf("C", "D", "E", "F", "G", "A", "B")
    val keyVariants = listOf("b", "#", "")
    val keyTypes = listOf("", "m")
    val chordTypes = listOf("", "maj", "6", "maj7", "m", "m7", "-7", "dom7", "dim7", "m7b5")

    val random = Random()

    override fun key(): String {
        return keys[random.nextInt(keys.size)] + keyVariants[random.nextInt(keyVariants.size)]
    }

    override fun chord(): String {
        return key() + chordTypes[random.nextInt(chordTypes.size)]
    }

    override fun instrument(): String {
        return fakeit!!.fetch("music.instruments")
    }

    override fun keyTypes(): String {
        return keyTypes[random.nextInt(keyTypes.size)]
    }

    override fun chordTypes(): String {
        return chordTypes[random.nextInt(chordTypes.size)]
    }
}