package com.example.onlinephonesshop.presentation.mainfragment

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinephonesshop.domain.entities.mainscreen.BestSeller

class DiffUtilBestSeller: DiffUtil.ItemCallback<BestSeller>() {

    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}