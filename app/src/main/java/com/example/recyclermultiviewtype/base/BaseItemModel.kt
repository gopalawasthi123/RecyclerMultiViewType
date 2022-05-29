package com.example.recyclermultiviewtype.base

import com.example.recyclermultiviewtype.factory.ItemTypeFactory

interface BaseItemModel {
    fun type(typeFactory: ItemTypeFactory) : Int;
}