package com.example.onlinephonesshop.presentation.mainfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.domain.entities.category.CategoryItem

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var positionItem = 0
    var listCategory = listOf<CategoryItem>()

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val categoryItemCard: CardView =
            itemView.findViewById(R.id.category_item_card)
        val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
        val nameCategory: TextView = itemView.findViewById(R.id.category_title)


        private val peachColor = ContextCompat.getColor(itemView.context, R.color.peach)
        private val whiteColor = ContextCompat.getColor(itemView.context, R.color.white)
        private val darkBlueColor = ContextCompat.getColor(itemView.context, R.color.dark_blue)

        init {
            categoryItemCard.setOnClickListener {
                positionItem = adapterPosition
                notifyDataSetChanged()
            }
        }

        fun defaultButton() {

            categoryImage.setColorFilter(
                ContextCompat.getColor(categoryImage.context, R.color.white)
            )
            nameCategory.setTextColor(peachColor)
            categoryItemCard.setCardBackgroundColor(peachColor)

        }

        fun selectedButton() {

            categoryImage.setColorFilter(
                ContextCompat.getColor(categoryImage.context, R.color.gray)
            )
            nameCategory.setTextColor(darkBlueColor)
            categoryItemCard.setCardBackgroundColor(whiteColor)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)

        return CategoryViewHolder(view.inflate(R.layout.category_item, parent, false))

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val getCategory = listCategory[position]
        holder.categoryImage.setImageResource(getCategory.icon)
        holder.nameCategory.text = getCategory.name

        if (positionItem == position) {
            holder.defaultButton()
        } else holder.selectedButton()

    }

    override fun getItemCount() = listCategory.size

}