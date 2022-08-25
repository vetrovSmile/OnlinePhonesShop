package com.example.onlinephonesshop.presentation.mainfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.category.CategoryItem
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import com.example.onlinephonesshop.domain.usecases.GetCategoryItemUseCase
import com.example.onlinephonesshop.domain.usecases.GetMainListDtoUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModalMainFragment @Inject constructor(
    private val getMainListDtoUseCase: GetMainListDtoUseCase,
    private val getCategoryItemUseCase: GetCategoryItemUseCase
) : ViewModel() {

    private val _getResponseMain = MutableLiveData<Response<MainPhoneList>>()
    val getResponseMainValue: LiveData<Response<MainPhoneList>> = _getResponseMain

    private val _category = MutableLiveData<List<CategoryItem>>()
    val category: LiveData<List<CategoryItem>> = _category

    fun getListCategory() {
        _category.postValue(getCategoryItemUseCase.invoke())

    }

    fun getResponseMain() {
        viewModelScope.launch {

            try {
                val responsePhoneList = getMainListDtoUseCase.invoke()
                _getResponseMain.value = responsePhoneList
                Log.d("ViewModalMainFragment", "$responsePhoneList")
            } catch (e: Exception) {

            }

        }
    }

}