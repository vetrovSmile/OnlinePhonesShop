package com.example.onlinephonesshop.data

import com.example.onlinephonesshop.domain.PhonesShopRepository
import com.example.onlinephonesshop.domain.entities.cartscreen.CartPhoneList
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import retrofit2.Response

class PhoneRepositoryImpl: PhonesShopRepository {
    override suspend fun getMainList(): Response<MainPhoneList> {
        return ApiFactory.apiService.getMainList()
    }

    override suspend fun getDetailList(): Response<DetailsPhoneList> {
        return ApiFactory.apiService.getDetailList()
    }

    override suspend fun getCartList(): Response<CartPhoneList> {
       return ApiFactory.apiService.getCartList()
    }


}