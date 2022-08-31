package com.example.onlinephonesshop.presentation.detailfragment

import androidx.recyclerview.widget.DiffUtil
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList

class DiffUtilDetailsFragment : DiffUtil.ItemCallback<DetailsPhoneList>() {

    override fun areItemsTheSame(oldItem: DetailsPhoneList, newItem: DetailsPhoneList): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DetailsPhoneList, newItem: DetailsPhoneList): Boolean {

        return oldItem == newItem
    }
}