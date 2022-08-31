package com.example.onlinephonesshop.data

import com.example.onlinephonesshop.domain.entities.cartscreen.CartPhoneList
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhone
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(MAIN_URL)
    suspend fun getMainList(): Response<MainPhoneList>

    @GET(DETAIL_URL)
    suspend fun getDetailList(): Response<DetailsPhoneList>

    @GET(CART_URL)
    suspend fun getCartList(): Response<CartPhoneList>

    companion object{

        private const val MAIN_URL  ="654bd15e-b121-49ba-a588-960956b15175"
        private const val DETAIL_URL  ="6c14c560-15c6-4248-b9d2-b4508df7d4f5"
        private const val CART_URL  ="53539a72-3c5f-4f30-bbb1-6ca10d42c149"

    }


}