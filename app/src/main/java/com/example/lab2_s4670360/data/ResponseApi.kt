package com.example.lab2_s4670360.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class ResponseApi {

    // Generates Moshi Adapter to convert JSON to Kotlin objects
    @JsonClass(generateAdapter = true)

// API response of how manny items in the list
    data class ApiResponse(
        // List of the objects from  ResponseItem
        @Json(name = "entities") val entities: List<ResponseItem>,
        // Integer: total entity
        @Json(name = "entityTotal") val entityTotal: Int
    )
}