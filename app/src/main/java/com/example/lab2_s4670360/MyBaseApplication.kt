package com.example.lab2_s4670360

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
// MyBaseApplication is the main application class.
// Sets up Dagger Hilt for dependency injection in the app.
// super.onCreate() makes sure everything is initialized properly.
@HiltAndroidApp
class MyBaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}