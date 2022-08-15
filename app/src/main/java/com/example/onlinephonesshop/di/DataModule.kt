package com.example.onlinephonesshop.di

import com.example.onlinephonesshop.data.PhoneRepositoryImpl
import com.example.onlinephonesshop.domain.PhonesShopRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindsRepository(impl: PhoneRepositoryImpl): PhonesShopRepository
}