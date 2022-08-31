package com.example.onlinephonesshop.domain

import com.example.onlinephonesshop.domain.entities.cartscreen.CartPhoneList
import com.example.onlinephonesshop.domain.entities.category.CategoryItem
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhone
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import retrofit2.Response

interface PhonesShopRepository {

    suspend fun getMainList(): Response<MainPhoneList>

    suspend fun getDetailList(): Response<DetailsPhoneList>

    suspend fun getCartList(): Response<CartPhoneList>

    fun getCategory(): List<CategoryItem>


}