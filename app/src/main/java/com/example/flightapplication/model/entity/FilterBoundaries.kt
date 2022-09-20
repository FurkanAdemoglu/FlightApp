package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class FilterBoundaries(
    @SerializedName("departureMaxDuration")
    val departureMaxDuration: Int,
    @SerializedName("departurePrice")
    val departurePrice: DeparturePrice,
    @SerializedName("returnMaxDuration")
    val returnMaxDuration: Int,
    @SerializedName("returnPrice")
    val returnPrice: ReturnPrice
)