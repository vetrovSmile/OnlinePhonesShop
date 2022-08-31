package com.example.onlinephonesshop.presentation.cartfragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.domain.entities.cartscreen.Basket
import com.example.onlinephonesshop.presentation.mainfragment.CategoryAdapter

class CartFragmentAdapter : RecyclerView.Adapter<CartFragmentAdapter.CartViewHolder>(){

    var total = 0
    var list = listOf<Basket>()
    set(value){
        field = value
        notifyDataSetChanged()

    }


    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageBasketItem: ImageView = itemView.findViewById(R.id.image_phone_basket)
        val titleBasketItem: TextView = itemView.findViewById(R.id.name_phone_basket)
        val priceBasketItem: TextView = itemView.findViewById(R.id.cost_phone)
        val minusButton: ImageButton = itemView.findViewById(R.id.button_minus)
        val plusButton: ImageButton = itemView.findViewById(R.id.button_plus)
        val countItem: TextView = itemView.findViewById(R.id.count_basket)
        val totalPrice: TextView = itemView.findViewById(R.id.cost_phone)
        val deleteItem: ImageButton = itemView.findViewById(R.id.delete_product_button)


//        init {
//            for (i in  0 until list.size){
//
//                total += list[i].price
//
//                Log.d("hello", "$total")
//            }
//
//        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
        return CartViewHolder(view.inflate(R.layout.basket_item, parent, false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val getBasketView = list[position]

        holder.titleBasketItem.text = getBasketView.title
        holder.priceBasketItem.text = getBasketView.price.toString()
        Glide.with(holder.imageBasketItem.context).load(getBasketView.images)
            .into(holder.imageBasketItem)

        holder.countItem.text = "1"
        holder.minusButton.setOnClickListener {
            if (holder.countItem.text.toString().toInt() >= 2) {
                val countMinus = holder.countItem.text.toString().toInt().minus(1)
                val totalPrice = getBasketView.price * countMinus
                holder.totalPrice.text = totalPrice.toString()
                holder.countItem.text = countMinus.toString()

            }

        }
        holder.plusButton.setOnClickListener {
            if (holder.countItem.text.toString().toInt() >= 0) {
                val countPlus = holder.countItem.text.toString().toInt().plus(1)
                val totalPrice = getBasketView.price * countPlus
                holder.totalPrice.text = totalPrice.toString()
                holder.countItem.text = countPlus.toString()

            }
        }

    }

    override fun getItemCount() = list.size

}