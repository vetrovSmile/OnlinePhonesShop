package com.example.onlinephonesshop.presentation.cartfragment

import androidx.lifecycle.ViewModel
import com.example.onlinephonesshop.domain.usecases.GetMainListDtoUseCase
import javax.inject.Inject

class ViewModalCartFragment @Inject constructor(
    private val getMainListDtoUseCase: GetMainListDtoUseCase
): ViewModel() {
}