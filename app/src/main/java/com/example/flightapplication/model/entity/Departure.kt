package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Departure(
    @SerializedName("average_price_breakdown")
    val averagePriceBreakdown: AveragePriceBreakdown,
    @SerializedName("different_airline_count")
    val differentAirlineCount: Int,
    @SerializedName("enuid")
    val enuid: String,
    @SerializedName("infos")
    val infos: Infos,
    @SerializedName("price_breakdown")
    val priceBreakdown: PriceBreakdown,
    @SerializedName("provider_packages")
    val providerPackages: List<Any>,
    @SerializedName("segments")
    val segments: List<Segment>
)