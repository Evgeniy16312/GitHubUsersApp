package com.example.retrofitapplication.app


import android.app.Application
import com.example.retrofitapplication.di.ApplicationComponent
import com.example.retrofitapplication.di.DaggerApplicationComponent


class App : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}