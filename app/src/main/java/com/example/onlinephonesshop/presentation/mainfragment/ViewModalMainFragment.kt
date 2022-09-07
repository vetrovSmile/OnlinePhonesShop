package com.example.onlinephonesshop.presentation.mainfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinephonesshop.domain.entities.category.CategoryItem
import com.example.onlinephonesshop.domain.entities.mainscreen.MainPhoneList
import com.example.onlinephonesshop.domain.entities.stateview.StateView
import com.example.onlinephonesshop.domain.usecases.GetCategoryItemUseCase
import com.example.onlinephonesshop.domain.usecases.GetMainListDtoUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModalMainFragment @Inject constructor(
    private val getMainListDtoUseCase: GetMainListDtoUseCase,
    private val getCategoryItemUseCase: GetCategoryItemUseCase
) : ViewModel() {

    private val errorHandlerMain = CoroutineExceptionHandler { _, error ->
        _viewStateMain.value = StateView(e = error)
    }

    private val _getResponseMain = MutableLiveData<Response<MainPhoneList>>()
    val getResponseMainValue: LiveData<Response<MainPhoneList>> = _getResponseMain

    private val _category = MutableLiveData<List<CategoryItem>>()
    val category: LiveData<List<CategoryItem>> = _category

    private val _viewStateMain = MutableLiveData<StateView>()
    val viewStateMain: LiveData<StateView> = _viewStateMain

    fun getListCategory() {
        _category.postValue(getCategoryItemUseCase.invoke())

    }

    fun getResponseMain() {
        viewModelScope.launch(errorHandlerMain) {

            val responsePhoneList = getMainListDtoUseCase.invoke()
            if (responsePhoneList.isSuccessful) {
                _getResponseMain.value = responsePhoneList
                _viewStateMain.value = StateView(true)
            }


        }
    }

}