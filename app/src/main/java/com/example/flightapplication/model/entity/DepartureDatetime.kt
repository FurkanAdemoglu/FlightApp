package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class DepartureDatetime(
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("timestamp")
    val timestamp: Int
)