package com.example.clone_everytime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class tip_list_item_data(val title : String, val subtitle : String)

class tip_list_viewholder(view : View)
    : RecyclerView.ViewHolder(view) {

    val title = view.findViewById<TextView>(R.id.tip_list_item_title)
    val subtitle = view.findViewById<TextView>(R.id.tip_list_item_subtitle)
}

class tip_list_adapter(val tip_list_item_datalist : ArrayList<tip_list_item_data>, val context : Context)
    : RecyclerView.Adapter<tip_list_viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tip_list_viewholder {
        val tip_list_item = LayoutInflater.from(context).inflate(R.layout.tip_list_item, parent, false)

        return tip_list_viewholder(tip_list_item)
    }

    override fun onBindViewHolder(holder: tip_list_viewholder, position: Int) {
        holder.title.text = tip_list_item_datalist[position].title
        holder.subtitle.text = tip_list_item_datalist[position].subtitle
    }

    override fun getItemCount(): Int {
        return tip_list_item_datalist.size
    }
}