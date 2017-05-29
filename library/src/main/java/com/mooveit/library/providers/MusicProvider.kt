package com.mooveit.library.providers

import com.mooveit.library.Fakeit.Companion.fakeit
import com.mooveit.library.providers.base.BaseProvider
import com.mooveit.library.providers.definition.MusicProvider
import java.util.*

class MusicProvider : BaseProvider(), MusicProvider {

    val keys = listOf("C", "D", "E", "F", "G", "A", "B")
    val keyVariants = listOf("b", "#", "")
    val keyTypes = listOf("", "m")
    val chordTypes = listOf("", "maj", "6", "maj7", "m", "m7", "-7", "dom7", "dim7", "m7b5")

    val random = Random()

    override fun key(): String {
        return getValue("key", { keys[random.nextInt(keys.size)] + keyVariants[random.nextInt(keyVariants.size)] })
    }

    override fun chord(): String {
        return getValue("chord", { key() + chordTypes[random.nextInt(chordTypes.size)] })
    }

    override fun instrument(): String {
        return getValue("instrument", { fakeit!!.fetch("music.instruments") })
    }

    override fun keyTypes(): String {
        return getValue("keyTypes", { keyTypes[random.nextInt(keyTypes.size)] })
    }

    override fun chordTypes(): String {
        return getValue("chordTypes", { chordTypes[random.nextInt(chordTypes.size)] })
    }
}