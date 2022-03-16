package com.example.recyclerview_viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_viewmodel.R
import com.example.recyclerview_viewmodel.model.Item

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var items: List<Item> = ArrayList()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_holder, parent, false)
            )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textView).text = items[position].name
        holder.itemView.findViewById<TextView>(R.id.textView2).text = items[position].balance

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun refreshUsers(users: List<Item>) {
        this.items = users
        notifyDataSetChanged()
    }
}