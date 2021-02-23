package com.example.clone_everytime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class tip_list_item_data(
        var icon : Int,
        var title : String,
        var subtitle : String,
        var subtltle_color : Int,
        var button : String
        )

class tip_list_adapter(val tip_list_item_datalist : ArrayList<tip_list_item_data>, val context : Context)
    : RecyclerView.Adapter<tip_list_adapter.tip_list_viewholder>(){

    interface OnTipListItemClickListener {
        fun onTipListItemClick(view: View, position: Int)
    }

    lateinit var ontiplistitemclicklistener : OnTipListItemClickListener

    fun setTipListItemClickListener(tiplistitemclicklistener : OnTipListItemClickListener) {
        this.ontiplistitemclicklistener = tiplistitemclicklistener
    }

    inner class tip_list_viewholder(itemview : View)
        : RecyclerView.ViewHolder(itemview) {

        val imageview = itemview.findViewById<ImageView>(R.id.tip_list_item_imageView)
        val title = itemview.findViewById<TextView>(R.id.tip_list_item_title)
        val subtitle = itemview.findViewById<TextView>(R.id.tip_list_item_subtitle)
        val button = itemview.findViewById<Button>(R.id.tip_list_item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tip_list_viewholder {
        val tip_list_item = LayoutInflater.from(context).inflate(R.layout.tip_list_item, parent, false)

        return tip_list_viewholder(tip_list_item)
    }

    override fun onBindViewHolder(holder: tip_list_viewholder, position: Int) {
        holder.imageview.setImageResource(tip_list_item_datalist[position].icon)
        holder.title.text = tip_list_item_datalist[position].title
        holder.subtitle.text = tip_list_item_datalist[position].subtitle
        holder.subtitle.setTextColor(tip_list_item_datalist[position].subtltle_color)
        holder.button.text = tip_list_item_datalist[position].button

        holder.itemView.setOnClickListener {
            ontiplistitemclicklistener.onTipListItemClick(it, position)
        }

        //아이템 안의 버튼 클릭 이벤트 구현 (이 앱에서는 아이템 클릭 이벤트와 동일)
        holder.button.setOnClickListener {
            ontiplistitemclicklistener.onTipListItemClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return tip_list_item_datalist.size
    }
}
