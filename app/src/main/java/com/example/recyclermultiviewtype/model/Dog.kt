package com.example.recyclermultiviewtype.model

import android.widget.TextView
import com.example.recyclermultiviewtype.base.BaseItemModel
import com.example.recyclermultiviewtype.factory.ItemTypeFactory

data class Dog(val name : String ) : BaseItemModel{

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}