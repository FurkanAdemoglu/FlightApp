package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class PriceHistory(
    @SerializedName("departure")
    val departure: DepartureX
)