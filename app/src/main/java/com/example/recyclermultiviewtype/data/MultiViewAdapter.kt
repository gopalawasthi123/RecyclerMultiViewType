package com.example.recyclermultiviewtype.data

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclermultiviewtype.base.AbstractViewHolder
import com.example.recyclermultiviewtype.base.BaseItemModel
import com.example.recyclermultiviewtype.factory.ItemTypeFactory

class MultiViewAdapter(
 private val itemTypeFactory: ItemTypeFactory,
) : RecyclerView.Adapter<AbstractViewHolder<BaseItemModel>>(){
    private val items : MutableList<BaseItemModel> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder<BaseItemModel> {
        val view = LayoutInflater.from(parent.context).inflate(viewType,parent,false);
        return itemTypeFactory.createView(view,viewType) as AbstractViewHolder<BaseItemModel>
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<BaseItemModel>, position: Int) {
        holder.binds(items[position])
    }

        fun setAnimalList(itemList : List<BaseItemModel>){
        items.clear()
        items.addAll(itemList)
            notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.count()


    override fun getItemViewType(position: Int): Int {
        return items[position].type(itemTypeFactory)
    }
}