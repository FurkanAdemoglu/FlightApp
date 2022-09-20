package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class SegmentAttributes(
    @SerializedName("airplane_brand")
    val airplaneBrand: String,
    @SerializedName("entertainment")
    val entertainment: String,
    @SerializedName("free_meal")
    val freeMeal: Boolean,
    @SerializedName("seat_pitch")
    val seatPitch: String,
    @SerializedName("seat_plan")
    val seatPlan: String,
    @SerializedName("wifi")
    val wifi: Int
)