package com.example.lab2_s4670360.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//password for login
//This class is used to model the login response from an API. The `keypass` might be a token or credential
//      needed for authentication
@JsonClass(generateAdapter = true)
data class ResponseLogin(
    @Json(name = "keypass") val keypass: String
)
