package com.example.todolist_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList as ArrayList1

class itemdata1(val title : String, val date : String, val todo : String)

class ViewHolder1(v : View, datalist1: ArrayList1<itemdata1>, onDbItemClickListener: OnDbItemClickListener) : RecyclerView.ViewHolder(v), View.OnClickListener {
    val title = v.findViewById<TextView>(R.id.titleview)
    val date = v.findViewById<TextView>(R.id.dateview)
    val todo = v.findViewById<TextView>(R.id.todoview)

    val _id = v.findViewById<TextView>(R.id.idview)



    var dataList11 : ArrayList1<itemdata1>
    var onDbItemClickListener : OnDbItemClickListener

    init {
        v.setOnClickListener(this)
        this.dataList11 = datalist1
        this.onDbItemClickListener = onDbItemClickListener
    }

    override fun onClick(v: View?) {
        this.onDbItemClickListener.onItemClick(dataList11, adapterPosition)
    }
}

class Adapter1(val dataList1 : ArrayList1<itemdata1>, val context : Context, onDbItemClickListener: OnDbItemClickListener)
    : RecyclerView.Adapter<ViewHolder1>(), OnDbItemClickListener {




    var onDbItemClickListener : OnDbItemClickListener? = null

    //생성자를 나중에
    init {
        this.onDbItemClickListener = onDbItemClickListener
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val itemRow1 = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return ViewHolder1(itemRow1, dataList1, this.onDbItemClickListener!!)
    }

    /*수정부분*/
    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.title.text = dataList1[position].title
        holder.date.text = dataList1[position].date
        holder.todo.text = dataList1[position].todo

        holder._id.text = position.toString()

//        holder.itemView.setOnClickListener {
//            Toast.makeText(context, dataList1[position].title + position, Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int {
        return dataList1.size
    }

    override fun onItemClick(datalist1: ArrayList1<itemdata1>, p: Int) {  }
}

interface OnDbItemClickListener {
    fun onItemClick(datalist1 : ArrayList1<itemdata1>, p : Int)
}