package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class SegmentDelay(
    @SerializedName("day")
    val day: Int,
    @SerializedName("hour")
    val hour: Int,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("total_minutes")
    val totalMinutes: Int
)