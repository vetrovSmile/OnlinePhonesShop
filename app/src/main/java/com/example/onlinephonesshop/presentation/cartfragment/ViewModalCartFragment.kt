package com.example.onlinephonesshop.presentation.cartfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.cartscreen.CartPhoneList
import com.example.onlinephonesshop.domain.entities.stateview.StateView
import com.example.onlinephonesshop.domain.usecases.GetCartListDtoUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModalCartFragment @Inject constructor(
    private val getCartListDtoUseCase: GetCartListDtoUseCase
) : ViewModel() {

    private val errorHandlerCart = CoroutineExceptionHandler { _, error ->
        _viewStateCart.value = StateView(e = error)

    }

    private val _basketItemResponse = MutableLiveData<Response<CartPhoneList>>()
    val basketItemResponse: LiveData<Response<CartPhoneList>> = _basketItemResponse


    private val _viewStateCart = MutableLiveData<StateView>()
    val viewStateCart: LiveData<StateView> = _viewStateCart


    fun getBasketItem() {

        viewModelScope.launch(errorHandlerCart) {
                val getBasketItemResponse = getCartListDtoUseCase.invoke()

            if (getBasketItemResponse.isSuccessful){
                _basketItemResponse.value = getBasketItemResponse
                _viewStateCart.value = StateView(true)
            }

        }
    }
}