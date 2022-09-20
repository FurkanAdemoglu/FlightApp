package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class ReturnPrice(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int
)