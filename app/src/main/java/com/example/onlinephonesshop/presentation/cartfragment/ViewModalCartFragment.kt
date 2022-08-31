package com.example.onlinephonesshop.presentation.cartfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.cartscreen.Basket
import com.example.onlinephonesshop.domain.entities.cartscreen.CartPhoneList
import com.example.onlinephonesshop.domain.usecases.GetCartListDtoUseCase
import com.example.onlinephonesshop.domain.usecases.GetMainListDtoUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModalCartFragment @Inject constructor(
    private val getCartListDtoUseCase: GetCartListDtoUseCase
): ViewModel() {

    private val _basketItemResponse = MutableLiveData<Response<CartPhoneList>>()
    val basketItemResponse: LiveData<Response<CartPhoneList>> = _basketItemResponse


    fun getBasketItem(){

        try {
            viewModelScope.launch {
                val getBasketItemResponse = getCartListDtoUseCase.invoke()
                _basketItemResponse.value = getBasketItemResponse

            }
        }catch (e: Exception){

        }



    }
}