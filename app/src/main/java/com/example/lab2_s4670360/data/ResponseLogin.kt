package com.example.lab2_s4670360.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//password for login
@JsonClass(generateAdapter = true)
data class ResponseLogin(
    @Json(name = "keypass") val keypass: String
)
