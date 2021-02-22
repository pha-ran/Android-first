package com.example.clone_everytime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recommended_information_data(
        var logo : Int,
        var name : String,
        var type : String,
        var content : Int,
        var title : String,
        var subtitle : String,
        var btn_text  : String )

class recommended_information_adapter(
        var recommended_information_datalist : ArrayList<recommended_information_data>,
        var context : Context)
    : RecyclerView.Adapter<recommended_information_adapter.recommended_information_viewholder>() {

    inner class recommended_information_viewholder(itemview : View)
        : RecyclerView.ViewHolder(itemview) {

        var logo = itemview.findViewById<ImageView>(R.id.recommended_information_item_logo)
        var name = itemview.findViewById<TextView>(R.id.recommended_information_item_name)
        var type = itemview.findViewById<TextView>(R.id.recommended_information_item_type)
        var content = itemview.findViewById<ImageView>(R.id.recommended_information_item_content)
        var title = itemview.findViewById<TextView>(R.id.recommended_information_item_title)
        var subtitle = itemview.findViewById<TextView>(R.id.recommended_information_item_subtitle)
        var btn_text = itemview.findViewById<TextView>(R.id.recommended_information_item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recommended_information_viewholder {
        val recommended_information_item = LayoutInflater.from(context).inflate(R.layout.recommended_information_item, parent, false)

        return recommended_information_viewholder(recommended_information_item)
    }

    override fun onBindViewHolder(holder: recommended_information_viewholder, position: Int) {
        holder.logo.setImageResource(recommended_information_datalist[position].logo)
        holder.name.text = recommended_information_datalist[position].name
        holder.type.text = recommended_information_datalist[position].type
        holder.content.setImageResource(recommended_information_datalist[position].content)
        holder.title.text = recommended_information_datalist[position].title
        holder.subtitle.text = recommended_information_datalist[position].subtitle
        holder.btn_text.text = recommended_information_datalist[position].btn_text
    }

    override fun getItemCount(): Int {
        return recommended_information_datalist.size
    }
}