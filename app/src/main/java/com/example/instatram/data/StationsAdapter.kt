package com.example.instatram.data

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instatram.R

class CountriesAdapter(private val stationList: List<Station>) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return stationList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${stationList.size} ")


        return holder.bind(stationList[position])

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {



        var stationName = itemView.findViewById<TextView>(R.id.button)

        fun bind(station: Station) {


            stationName.text = station.name


        }

    }
}