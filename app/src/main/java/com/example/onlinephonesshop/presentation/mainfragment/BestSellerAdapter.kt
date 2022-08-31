package com.example.onlinephonesshop.presentation.mainfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.domain.entities.mainscreen.BestSeller

class BestSellerAdapter :
    ListAdapter<BestSeller, BestSellerAdapter.BestSellerViewHolder>(DiffUtilBestSeller()) {

    var cardClickShow: CardClickListener? = null
    private var checked = false




    inner class BestSellerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val phoneImageBestSeller: ImageView = itemView.findViewById(R.id.image_phone)
        val priceWithDiscount: TextView = itemView.findViewById(R.id.price_info)
        val priceWithoutDiscount: TextView = itemView.findViewById(R.id.price_sale_info)
        val phoneInfoBestSeller: TextView = itemView.findViewById(R.id.phone_info_bestSeller)
        val favoriteButton: RadioButton = itemView.findViewById(R.id.favorite_button)
        val cardPhoneBestSeller: CardView = itemView.findViewById(R.id.cardView_phone_item)

        init {
            favoriteButton.setOnClickListener {
                if (checked){
                    favoriteButton.isChecked = false
                    checked = false
                }else checked = true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val view = LayoutInflater.from(parent.context)
        return BestSellerViewHolder(view.inflate(R.layout.phone_item, parent, false))

    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val getBestSeller = getItem(position)
        holder.priceWithDiscount.text = getBestSeller.discount_price.toString()
        holder.priceWithoutDiscount.text = getBestSeller.price_without_discount.toString()
        holder.phoneInfoBestSeller.text = getBestSeller.title
        Glide.with(holder.itemView.context).load(getBestSeller.picture)
            .into(holder.phoneImageBestSeller)
        holder.cardPhoneBestSeller.setOnClickListener {

            cardClickShow?.cardClick()
        }

    }

    interface CardClickListener{

        fun cardClick()
    }

}