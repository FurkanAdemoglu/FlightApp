package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("code")
    val code: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)