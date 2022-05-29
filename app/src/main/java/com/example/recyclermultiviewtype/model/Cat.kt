package com.example.recyclermultiviewtype.model

import com.example.recyclermultiviewtype.base.BaseItemModel
import com.example.recyclermultiviewtype.factory.ItemTypeFactory

 data class Cat(val name : String) : BaseItemModel{
    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }

}