package com.example.onlinephonesshop.data

import com.example.onlinephonesshop.R
import com.example.onlinephonesshop.domain.PhonesShopRepository
import com.example.onlinephonesshop.domain.entities.cartscreen.CartPhoneList
import com.example.onlinephonesshop.domain.entities.category.CategoryItem
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import retrofit2.Response
import javax.inject.Inject

class PhoneRepositoryImpl @Inject constructor () : PhonesShopRepository {
    override suspend fun getMainList(): Response<MainPhoneList> {
        return ApiFactory.apiService.getMainList()
    }

    override suspend fun getDetailList(): Response<DetailsPhoneList> {
        return ApiFactory.apiService.getDetailList()
    }

    override suspend fun getCartList(): Response<CartPhoneList> {
       return ApiFactory.apiService.getCartList()
    }

    override fun getCategory(): List<CategoryItem> = listOf(
        CategoryItem(
            icon = R.drawable.ic_phone_icon,
            name = "Phones"
        ),
        CategoryItem(
            icon = R.drawable.ic_computer_icon,
            name = "Computer"
        ),
        CategoryItem(
            icon = R.drawable.ic_heals_icon,
            name = "Heals"
        ),
        CategoryItem(
            icon = R.drawable.ic_books_icon,
            name = "Books"
        )
    )
}