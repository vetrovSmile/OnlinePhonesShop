package com.example.onlinephonesshop.di

import android.app.Application
import com.example.onlinephonesshop.presentation.ApplicationApp
import com.example.onlinephonesshop.presentation.cartfragment.MyCartFragment
import com.example.onlinephonesshop.presentation.cartfragment.ViewModalCartFragment
import com.example.onlinephonesshop.presentation.detailfragment.DetailsFragment
import com.example.onlinephonesshop.presentation.detailfragment.ViewModalDetailFragment
import com.example.onlinephonesshop.presentation.mainfragment.MainFragment
import com.example.onlinephonesshop.presentation.mainfragment.ViewModalMainFragment
import dagger.BindsInstance
import dagger.Component
@ApplicationScope
@Component(modules = [ViewModalModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(fragment: MainFragment)

    fun inject(fragment: DetailsFragment)

    fun inject(fragment: MyCartFragment)

    fun inject(application: ApplicationApp)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance
                   application: Application): ApplicationComponent
    }
}