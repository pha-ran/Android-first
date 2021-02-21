package com.example.clone_everytime

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class popular_posts_data(
        var profileimage : Int,
        var name : String,
        var date : String,
        var content : String,
        var board : String,
        var like : Int,
        var comment : Int
)

class popular_posts_adapter(var popular_posts_datalist : ArrayList<popular_posts_data>, var context: Context)
    : RecyclerView.Adapter<popular_posts_adapter.popular_posts_viewholder>() {

    inner class popular_posts_viewholder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        var profileimage = itemview.findViewById<ImageView>(R.id.popular_posts_profileimage)
        var name = itemview.findViewById<TextView>(R.id.popular_posts_name)
        var date = itemview.findViewById<TextView>(R.id.popular_posts_date)
        var content = itemview.findViewById<TextView>(R.id.popular_posts_content)
        var board = itemview.findViewById<TextView>(R.id.popular_posts_board)
        var like = itemview.findViewById<TextView>(R.id.popular_posts_like)
        var comment = itemview.findViewById<TextView>(R.id.popular_posts_comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): popular_posts_viewholder {
        val popular_posts_item = LayoutInflater.from(context).inflate(R.layout.popular_posts_item, parent, false)

        return popular_posts_viewholder(popular_posts_item)
    }

    override fun onBindViewHolder(holder: popular_posts_viewholder, position: Int) {
        holder.profileimage.setImageResource(popular_posts_datalist[position].profileimage)
        holder.name.text = popular_posts_datalist[position].name
        holder.date.text = popular_posts_datalist[position].date
        holder.content.text = popular_posts_datalist[position].content
        holder.board.text = popular_posts_datalist[position].board
        holder.like.text = popular_posts_datalist[position].like.toString()
        holder.comment.text = popular_posts_datalist[position].comment.toString()
    }

    override fun getItemCount(): Int {
        return 2
    }
}