package com.example.onlinephonesshop.presentation.detailfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList
import com.example.onlinephonesshop.domain.entities.stateview.StateView
import com.example.onlinephonesshop.domain.usecases.GetDetailListDtoUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModalDetailFragment @Inject constructor(
    private val getDetailListDtoUseCase: GetDetailListDtoUseCase
) : ViewModel() {

    private val _getDetailList = MutableLiveData<Response<DetailsPhoneList>>()
    val getDetailList: LiveData<Response<DetailsPhoneList>> = _getDetailList


    private val _viewStateDetail = MutableLiveData<StateView>()
    val viewStateMain: LiveData<StateView> = _viewStateDetail

    fun getDetailListInfo() {

        viewModelScope.launch {
            val detailInfo = getDetailListDtoUseCase.invoke()
            _getDetailList.value = detailInfo
            _viewStateDetail.value = StateView(true)


        }

    }
}