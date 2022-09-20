package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class CarryOn(
    @SerializedName("allowance")
    val allowance: Int,
    @SerializedName("is_small")
    val isSmall: Boolean,
    @SerializedName("part")
    val part: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String
)