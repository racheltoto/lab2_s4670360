package com.example.lab2_s4670360

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyBaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}