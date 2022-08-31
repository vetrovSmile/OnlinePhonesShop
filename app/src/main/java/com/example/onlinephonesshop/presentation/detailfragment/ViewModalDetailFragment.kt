package com.example.onlinephonesshop.presentation.detailfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhone
import com.example.onlinephonesshop.domain.entities.detailscreen.DetailsPhoneList
import com.example.onlinephonesshop.domain.usecases.GetDetailListDtoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Response
import javax.inject.Inject

class ViewModalDetailFragment @Inject constructor(
    private val getDetailListDtoUseCase: GetDetailListDtoUseCase
) : ViewModel() {

    private val _getDetailList = MutableLiveData<Response<DetailsPhoneList>>()
    val getDetailList: LiveData<Response<DetailsPhoneList>> = _getDetailList

     fun getDetailListInfo() {

        viewModelScope.launch {
            val detailInfo = getDetailListDtoUseCase.invoke()
            _getDetailList.value = detailInfo
            Log.d("ViewModalDetailFragment", "$detailInfo")


        }

    }
}