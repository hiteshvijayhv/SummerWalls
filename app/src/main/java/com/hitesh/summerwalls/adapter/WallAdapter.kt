package com.hitesh.summerwalls.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hitesh.summerwalls.R
import com.hitesh.summerwalls.WallViewItems
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.wall_layout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class WallAdapter(private val wallViewItems: List<WallViewItems>) :
    RecyclerView.Adapter<WallAdapter.WallViewHolder>(){

    inner class WallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.textView
        var imageView = itemView.wallpaper

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallAdapter.WallViewHolder {
       val itemView = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.wall_layout, parent, false)
        return WallViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: WallAdapter.WallViewHolder, position: Int) {
        val currentItem = wallViewItems[position]
        holder.textView.text = currentItem.text

        holder.imageView.load(currentItem.imageUrl)
    }

    override fun getItemCount(): Int {
        return wallViewItems.size
    }
}
