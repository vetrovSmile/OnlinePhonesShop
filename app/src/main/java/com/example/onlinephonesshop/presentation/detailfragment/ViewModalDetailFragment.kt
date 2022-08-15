package com.example.onlinephonesshop.presentation.detailfragment

import androidx.lifecycle.ViewModel
import com.example.onlinephonesshop.domain.usecases.GetDetailListDtoUseCase
import javax.inject.Inject

class ViewModalDetailFragment @Inject constructor (
    private val getDetailListDtoUseCase: GetDetailListDtoUseCase
        ): ViewModel() {
}