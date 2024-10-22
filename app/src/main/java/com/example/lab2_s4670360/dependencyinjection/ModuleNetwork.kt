package com.example.lab2_s4670360.dependencyinjection

import com.example.lab2_s4670360.network.ApiRetrofitClient
import com.example.lab2_s4670360.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Marks this class as a Dagger module, which is used to provide dependencies.
@Module

//- Specifies that this module is installed in the `SingletonComponent`, meaning the provided dependencies
//      will have a singleton lifecycle
@InstallIn(SingletonComponent::class)

//Declares a Kotlin `object`, which ensures that only one instance of this module exists at runtime.
object ModuleNetwork{
    @Provides

    @Singleton
//This function returns an instance of `ApiService`. It uses `ApiRetrofitClient.apiService` to get the actual
//      implementation of the `ApiService`. Dagger will call this method when the `ApiService` is required.
    fun provideApiService(): ApiService {

        return ApiRetrofitClient.apiService
    }
}