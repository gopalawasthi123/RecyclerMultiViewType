package com.example.recyclermultiviewtype.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewHolder<in T> (private val view : View) : RecyclerView.ViewHolder(view) {

    abstract fun binds(element: T)
}