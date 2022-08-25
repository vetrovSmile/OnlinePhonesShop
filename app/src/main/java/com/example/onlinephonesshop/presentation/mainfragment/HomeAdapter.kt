package com.example.onlinephonesshop.presentation.mainfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.domain.entities.mainscreen.HomeStore

class HomeAdapter: ListAdapter<HomeStore, HomeAdapter.HomeViewHolder>(HomeDiffUtil()) {


    inner class HomeViewHolder(view: View): RecyclerView.ViewHolder(view){

         val imagePhoneHome: ImageView = itemView.findViewById(R.id.home_main_image)
         val imageNewHome: ImageView = itemView.findViewById(R.id.new_icon)
         val titleHome: TextView = itemView.findViewById(R.id.name_phone)
         val subtitleHome: TextView = itemView.findViewById(R.id.description_phone)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)

        return HomeViewHolder(view.inflate(R.layout.home_item, parent,false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val getItemHome = getItem(position)
        holder.titleHome.text = getItemHome.title
        holder.subtitleHome.text = getItemHome.subtitle
        if (getItemHome.is_new != null){
            holder.imageNewHome.visibility = View.VISIBLE
        }else holder.imageNewHome.visibility = View.INVISIBLE

        Glide
            .with(holder.imagePhoneHome.context)
            .load(getItemHome.picture)
            .into(holder.imagePhoneHome)
    }


}