package com.example.onlinephonesshop.di

import androidx.lifecycle.ViewModel
import com.example.onlinephonesshop.presentation.cartfragment.ViewModalCartFragment
import com.example.onlinephonesshop.presentation.detailfragment.ViewModalDetailFragment
import com.example.onlinephonesshop.presentation.mainfragment.ViewModalMainFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModalModule {

    @Binds
    @IntoMap
    @ViewModalKey(ViewModalMainFragment::class)
    fun bindViewModalMain(viewModal : ViewModalMainFragment): ViewModel

    @Binds
    @IntoMap
    @ViewModalKey(ViewModalDetailFragment::class)
    fun bindViewModalDetails(viewModal: ViewModalDetailFragment): ViewModel

    @Binds
    @IntoMap
    @ViewModalKey(ViewModalCartFragment::class)
    fun bindViewModalCart(viewModal: ViewModalCartFragment): ViewModel

}