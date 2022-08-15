package com.example.onlinephonesshop.domain.usecases

import com.example.onlinephonesshop.domain.PhonesShopRepository

class GetCartListDtoUseCase(
    private val repository: PhonesShopRepository
) {

    suspend operator fun invoke() = repository.getCartList()

}