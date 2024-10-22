package com.example.lab2_s4670360.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// This data class is typically used when sending login information to a server or receiving it.
@JsonClass(generateAdapter = true)
data class RequestLogin(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)