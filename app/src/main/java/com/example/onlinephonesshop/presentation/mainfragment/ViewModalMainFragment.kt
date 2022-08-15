package com.example.onlinephonesshop.presentation.mainfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import com.example.onlinephonesshop.domain.usecases.GetMainListDtoUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModalMainFragment @Inject constructor(
    private val getMainListDtoUseCase: GetMainListDtoUseCase
) : ViewModel(){

    private val _getResponseMain = MutableLiveData<Response<MainPhoneList>>()
    val getResponseMain:  LiveData<Response<MainPhoneList>> = _getResponseMain

    fun getResponseMain(){
        viewModelScope.launch {
            val responsePhoneList = getMainListDtoUseCase.invoke()
            _getResponseMain.value = responsePhoneList
            Log.d("ViewModalMainFragment", "$responsePhoneList")
        }
    }


}