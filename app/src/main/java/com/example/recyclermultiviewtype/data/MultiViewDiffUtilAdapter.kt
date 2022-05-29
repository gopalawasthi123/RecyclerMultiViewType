package com.example.recyclermultiviewtype.data

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclermultiviewtype.R
import com.example.recyclermultiviewtype.base.AbstractViewHolder
import com.example.recyclermultiviewtype.base.BaseItemModel
import com.example.recyclermultiviewtype.factory.ItemTypeFactory
import com.example.recyclermultiviewtype.model.Cat
import com.example.recyclermultiviewtype.model.Dog
import kotlin.time.measureTime

class MultiViewDiffUtilAdapter(private val itemTypeFactory: ItemTypeFactory) :
    ListAdapter<BaseItemModel, AbstractViewHolder<BaseItemModel>>(DIFF_COMPARATOR) {

    companion object {
        val DIFF_COMPARATOR = object : DiffUtil.ItemCallback<BaseItemModel>() {
            override fun areItemsTheSame(oldItem: BaseItemModel, newItem: BaseItemModel): Boolean {
                if (oldItem is Cat && newItem is Cat) {
                    return oldItem.name == newItem.name
                } else if (oldItem is Dog && newItem is Dog) {
                    return oldItem.name == newItem.name
                }
                return false
            }

            override fun areContentsTheSame(
                oldItem: BaseItemModel,
                newItem: BaseItemModel
            ): Boolean {
                if (oldItem is Cat && newItem is Cat)
                    return oldItem == newItem
                else if (oldItem is Dog && newItem is Dog)
                    return oldItem == newItem
                return false
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder<BaseItemModel> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false);
        return itemTypeFactory.createView(view, viewType) as AbstractViewHolder<BaseItemModel>
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<BaseItemModel>, position: Int) {
        holder.binds(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type(itemTypeFactory)
    }


}