package com.example.onlinephonesshop.presentation

import android.app.Application
import com.example.onlinephonesshop.di.DaggerApplicationComponent

class ApplicationApp: Application() {

    val component by lazy {

         DaggerApplicationComponent.factory().create(this)

    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}