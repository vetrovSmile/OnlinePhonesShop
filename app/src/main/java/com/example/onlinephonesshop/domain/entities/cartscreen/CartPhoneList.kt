package com.example.onlinephonesshop.domain.entities.cartscreen

data class CartPhoneList(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)