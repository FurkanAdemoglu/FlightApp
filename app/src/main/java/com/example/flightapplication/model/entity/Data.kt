package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("airlines")
    val airlines: List<Airline>,
    @SerializedName("airports")
    val airports: List<Airport>,
    @SerializedName("baggages")
    val baggages: List<Int>,
    @SerializedName("bus_search_data_tab")
    val busSearchDataTab: Any,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("currencies")
    val currencies: Currencies,
    @SerializedName("filter_boundaries")
    val filterBoundaries: FilterBoundaries,
    @SerializedName("flights")
    val flights: Flights,
    @SerializedName("has_vi_flight")
    val hasViFlight: Boolean,
    @SerializedName("info_message")
    val infoMessage: Any,
    @SerializedName("price_history")
    val priceHistory: PriceHistory,
    @SerializedName("search_parameters")
    val searchParameters: SearchParameters,
    @SerializedName("search_url")
    val searchUrl: String,
    @SerializedName("short_search_url")
    val shortSearchUrl: String,
    @SerializedName("stop_counts")
    val stopCounts: List<Int>
)