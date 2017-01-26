package com.mooveit.library.providers

import android.content.Context
import com.mooveit.library.R
import com.mooveit.library.providers.definition.NameProvider
import java.util.*

class NameProviderImpl(context: Context) : NameProvider {

    private val firstNames: List<String> = Arrays.asList(*context.resources.getStringArray(R.array.first_names))
    private val lastNames: List<String> = Arrays.asList(*context.resources.getStringArray(R.array.last_names))
    private val prefixes: List<String> = Arrays.asList(*context.resources.getStringArray(R.array.prefixes))
    private val titles: List<String> = Arrays.asList(*context.resources.getStringArray(R.array.title))
    private val nameDividers: List<String> = Arrays.asList(*context.resources.getStringArray(R.array.name_dividers))

    override fun firstName(): String {
        return firstNames[Random().nextInt(firstNames.size)]
    }

    override fun lastName(): String {
        return lastNames[Random().nextInt(lastNames.size)]
    }

    override fun fullName(): String {
        return prefix() + " " + firstName() + " " + lastName()
    }

    override fun fullWithMiddleName(): String {
        return prefix() + " " + firstName() + " " + firstName() + " " + lastName()
    }

    override fun userName(): String {
        return firstName().toLowerCase() + nameDividers[Random().nextInt(nameDividers.size)] + lastName().toLowerCase()
    }

    override fun prefix(): String {
        return prefixes[Random().nextInt(prefixes.size)]
    }

    override fun title(): String {
        return titles[Random().nextInt(titles.size)]
    }
}
