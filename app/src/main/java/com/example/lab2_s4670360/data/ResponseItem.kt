package com.example.lab2_s4670360.data

import android.content.ClipDescription
import android.location.Location
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.time.Year

//for recyclerview
// This class can be used to model data received from an API, and it can be passed between Android components
//      via intents or saved in bundles
@Parcelize
data class ResponseItem(
    @Json(name = "event") val eventName: String,
    @Json(name = "startYear") val startYear: Int,
    @Json(name = "endYear") val endYear: Int,
    @Json(name = "location") val location: String,
    @Json(name = "keyFigure") val keyFigure: String,
    @Json(name = "description") val description: String

): Parcelable