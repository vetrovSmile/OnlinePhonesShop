package com.example.onlinephonesshop.domain.entities.mainscreen

data class HomeStore(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean? = null,
    val picture: String,
    val subtitle: String,
    val title: String
)