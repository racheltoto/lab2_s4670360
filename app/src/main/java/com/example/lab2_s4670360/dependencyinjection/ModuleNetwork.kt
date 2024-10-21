package com.example.lab2_s4670360.dependencyinjection

import com.example.lab2_s4670360.network.ApiRetrofitClient
import com.example.lab2_s4670360.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object ModuleNetwork{
    @Provides

    @Singleton

    fun provideApiService(): ApiService {

        return ApiRetrofitClient.apiService
    }
}