package com.example.recyclermultiviewtype.data

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclermultiviewtype.R
import com.example.recyclermultiviewtype.base.AbstractViewHolder
import com.example.recyclermultiviewtype.model.Cat

class CatViewHolder(private val view : View) : AbstractViewHolder<Cat>(view) {
    private val textView : TextView = view.findViewById(R.id.txtCatView)
    override fun binds(element: Cat) {
        textView.text = element.name
    }
}