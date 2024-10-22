package com.example.lab2_s4670360.network

import com.example.lab2_s4670360.data.RequestLogin
import com.example.lab2_s4670360.data.ResponseApi
import com.example.lab2_s4670360.data.ResponseLogin
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

//The ApiService interface contains methods for making HTTP requests to the server.
interface ApiService {

//Sends user login details (username and password) to the server using a POST request.
    @POST("footscray/auth")
    suspend fun login(@Body request: RequestLogin): ResponseLogin

//Retrieves historical data from the server using a GET request
    @GET("dashboard/history")
    suspend fun getHistory(
        @Header("Authorization") keypass: String
    ): ResponseApi.ApiResponse
}
