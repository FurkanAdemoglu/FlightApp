package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Flights(
    @SerializedName("departure")
    val departure: List<Departure>
)