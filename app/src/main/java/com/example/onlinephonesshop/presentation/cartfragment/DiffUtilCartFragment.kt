package com.example.onlinephonesshop.presentation.cartfragment

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinephonesshop.domain.entities.cartscreen.Basket

class DiffUtilCartFragment : DiffUtil.ItemCallback<Basket>() {

    override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem == newItem
    }
}