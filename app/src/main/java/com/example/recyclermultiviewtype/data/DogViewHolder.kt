package com.example.recyclermultiviewtype.data

import android.view.View
import android.widget.TextView
import com.example.recyclermultiviewtype.R
import com.example.recyclermultiviewtype.base.AbstractViewHolder
import com.example.recyclermultiviewtype.model.Dog

class DogViewHolder(private val view : View) : AbstractViewHolder<Dog>(view) {
    private val textView: TextView = view.findViewById(R.id.txtDogView)
    override fun binds(element: Dog) {
        textView.text = element.name
    }
}