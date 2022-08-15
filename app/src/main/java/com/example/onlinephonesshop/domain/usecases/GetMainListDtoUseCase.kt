package com.example.onlinephonesshop.domain.usecases

import com.example.onlinephonesshop.domain.PhonesShopRepository
import javax.inject.Inject

class GetMainListDtoUseCase @Inject constructor(
   private val repository: PhonesShopRepository
) {

    suspend operator fun invoke() = repository.getMainList()

}