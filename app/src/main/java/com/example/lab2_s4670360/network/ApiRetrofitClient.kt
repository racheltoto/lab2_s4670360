package com.example.lab2_s4670360.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//The `ApiRetrofitClient` object is responsible for setting up the Retrofit client to make network requests.
object ApiRetrofitClient {
//The base URL for the API endpoint that the app will communicate with.
    private const val BASE_URL = "https://nit3213-api-h2b3-latest.onrender.com/"
    //- Adds logging to the HTTP requests and responses, logging the entire request and response bodies to help with debugging.
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
// A custom HTTP client is built using OkHttp, with the logging interceptor added.
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
// Moshi is used as the JSON converter. `KotlinJsonAdapterFactory` allows Moshi to work with Kotlin data classes.
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Configures Retrofit with the base URL, the Moshi converter for JSON serialization/deserialization,
    //      and the custom `OkHttpClient`
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()
//This is the public `ApiService` instance that other parts of the app will use to make network requests.
//      It's created using Retrofit and will handle making API calls and converting responses.
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}