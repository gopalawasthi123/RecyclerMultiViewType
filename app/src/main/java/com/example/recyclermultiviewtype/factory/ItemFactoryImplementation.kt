package com.example.recyclermultiviewtype.factory

import android.view.View
import com.example.recyclermultiviewtype.R
import com.example.recyclermultiviewtype.base.AbstractViewHolder
import com.example.recyclermultiviewtype.data.CatViewHolder
import com.example.recyclermultiviewtype.data.DogViewHolder
import com.example.recyclermultiviewtype.model.Cat
import com.example.recyclermultiviewtype.model.Dog
import java.lang.RuntimeException

class ItemFactoryImplementation : ItemTypeFactory {
    override fun type(dog: Dog): Int {
        return R.layout.dog_item
    }

    override fun type(cat: Cat): Int {
        return R.layout.cat_item
    }

    override fun createView(parent: View, viewType: Int): AbstractViewHolder<*> {
        return when(viewType){
            R.layout.dog_item -> DogViewHolder(view = parent)
            R.layout.cat_item -> CatViewHolder(view= parent)
            else -> throw RuntimeException("Illegal view Type")

        }
    }
}