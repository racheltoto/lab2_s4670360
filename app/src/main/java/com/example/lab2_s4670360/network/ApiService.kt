package com.example.lab2_s4670360.network

import com.example.lab2_s4670360.data.RequestLogin
import com.example.lab2_s4670360.data.ResponseLogin
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {


    @POST("footscray/auth")
    suspend fun login(@Body request: RequestLogin): ResponseLogin


//    @GET("dashboard/history")
//    suspend fun getHistory(
//        @Header("Authorization") keypass: String
//    ): ApiResponse
//}

}