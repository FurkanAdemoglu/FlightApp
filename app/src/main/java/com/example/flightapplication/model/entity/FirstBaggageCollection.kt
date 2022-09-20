package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class FirstBaggageCollection(
    @SerializedName("allowance")
    val allowance: Int,
    @SerializedName("part")
    val part: Int,
    @SerializedName("paxType")
    val paxType: String,
    @SerializedName("small")
    val small: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String
)