package com.example.onlinephonesshop.domain.usecases

import com.example.onlinephonesshop.domain.PhonesShopRepository
import javax.inject.Inject

class GetCategoryItemUseCase @Inject constructor(
    private val repository: PhonesShopRepository
) {
    operator fun invoke () = repository.getCategory()
}