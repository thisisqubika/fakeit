package com.mooveit.library.providers

import android.content.res.Resources
import com.mooveit.library.R
import com.mooveit.library.providers.definition.BusinessProvider
import java.util.*

class BusinessProviderImpl(resources: Resources): BusinessProvider {

    private val namesList = resources.getStringArray(R.array.names)
    private val typeList = resources.getStringArray(R.array.type)
    private val subTypeList = resources.getStringArray(R.array.subtype)
    private val random = Random()

    override fun name(): String {
        return namesList[random.nextInt(namesList.size)]
    }

    override fun type(): String {
        return typeList[random.nextInt(typeList.size)]
    }

    override fun subType(): String {
        return subTypeList[random.nextInt(subTypeList.size)]
    }
}

