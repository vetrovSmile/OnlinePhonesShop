package com.example.onlinephonesshop.domain.usecases

import com.example.onlinephonesshop.domain.PhonesShopRepository

class GetMainListDtoUseCase(
   private val repository: PhonesShopRepository
) {

    suspend operator fun invoke() = repository.getMainList()

}