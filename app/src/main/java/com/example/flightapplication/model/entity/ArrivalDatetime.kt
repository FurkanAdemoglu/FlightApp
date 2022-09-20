package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class ArrivalDatetime(
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("timestamp")
    val timestamp: Int
)