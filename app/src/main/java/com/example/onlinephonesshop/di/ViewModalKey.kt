package com.example.onlinephonesshop.di

import androidx.lifecycle.ViewModel
import com.example.onlinephonesshop.presentation.mainfragment.ViewModalMainFragment
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModalKey(val value: KClass<out ViewModel>)
