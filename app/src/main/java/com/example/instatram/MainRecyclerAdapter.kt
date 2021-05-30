package com.example.instatram


import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.StringBuilder



val titles = mutableListOf<String>()
val images = mutableListOf<String>()


class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameText.text= titles[position]
        holder.image.setImageURI(Uri.parse(images[position]))}

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.station_item, parent, false)
        return ViewHolder(view)
    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.textView)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
    }}
