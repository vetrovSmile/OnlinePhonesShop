package com.example.onlinephonesshop.presentation.mainfragment

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinephonesshop.domain.entities.mainscreen.HomeStore

class HomeDiffUtil: DiffUtil.ItemCallback<HomeStore>() {

    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}