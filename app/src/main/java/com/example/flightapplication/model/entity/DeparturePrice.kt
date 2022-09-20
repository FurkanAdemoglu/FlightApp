package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class DeparturePrice(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int
)