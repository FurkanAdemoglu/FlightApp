package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val `data`: Data
)