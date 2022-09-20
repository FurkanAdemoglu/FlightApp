package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class DepartureX(
    @SerializedName("next_day_price")
    val nextDayPrice: Int,
    @SerializedName("previous_day_price")
    val previousDayPrice: Int
)