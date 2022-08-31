package com.example.onlinephonesshop.presentation.detailfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList

class DetailAdapter :
    ListAdapter<DetailsPhoneList, DetailAdapter.DetailViewHolder>(DiffUtilDetailsFragment()) {

    inner class DetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imagePhoneDetails: ImageView = itemView.findViewById(R.id.image_phone_details)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context)
        return DetailViewHolder(view.inflate(R.layout.phone_item_details, parent, false))
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val getPhotoDetails = getItem(position)
        Glide.with(holder.itemView.context).load(getPhotoDetails.images[1])
            .into(holder.imagePhoneDetails)


    }
}