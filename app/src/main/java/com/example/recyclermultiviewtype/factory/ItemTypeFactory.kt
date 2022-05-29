package com.example.recyclermultiviewtype.factory

import android.view.View
import com.example.recyclermultiviewtype.base.AbstractViewHolder
import com.example.recyclermultiviewtype.model.Cat
import com.example.recyclermultiviewtype.model.Dog

interface ItemTypeFactory {
    fun type(dog : Dog) : Int
    fun type(cat : Cat) : Int

    fun createView(parent : View, viewType : Int) : AbstractViewHolder<*>
}