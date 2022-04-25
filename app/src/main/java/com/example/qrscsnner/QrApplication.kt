package com.example.qrscsnner

import android.app.Application
import com.example.qrscsnner.di.AppComponent
import com.example.qrscsnner.di.DaggerAppComponent

class QrApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}