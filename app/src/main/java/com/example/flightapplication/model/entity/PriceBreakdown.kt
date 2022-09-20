package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class PriceBreakdown(
    @SerializedName("base")
    val base: Double,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("displayed_currency")
    val displayedCurrency: String,
    @SerializedName("extra_fee")
    val extraFee: Double,
    @SerializedName("internal_assurance")
    val internalAssurance: Int,
    @SerializedName("penalty")
    val penalty: Int,
    @SerializedName("reissue_service")
    val reissueService: Int,
    @SerializedName("service")
    val service: Double,
    @SerializedName("tax")
    val tax: Double,
    @SerializedName("total")
    val total: Double
){
    fun price():String="${total} ${displayedCurrency}"
}