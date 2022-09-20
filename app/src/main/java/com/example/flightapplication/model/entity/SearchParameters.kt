package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class SearchParameters(
    @SerializedName("adult")
    val adult: Int,
    @SerializedName("child")
    val child: Int,
    @SerializedName("departure_date")
    val departureDate: String,
    @SerializedName("departure_dates")
    val departureDates: List<String>,
    @SerializedName("destination")
    val destination: Destination,
    @SerializedName("destinations")
    val destinations: List<Destination>,
    @SerializedName("display_departure_date")
    val displayDepartureDate: String,
    @SerializedName("display_departure_dates")
    val displayDepartureDates: List<String>,
    @SerializedName("display_return_date")
    val displayReturnDate: Any,
    @SerializedName("flight_class")
    val flightClass: String,
    @SerializedName("infant")
    val infant: Int,
    @SerializedName("is_direct")
    val isDirect: Boolean,
    @SerializedName("is_domestic")
    val isDomestic: Boolean,
    @SerializedName("is_one_way")
    val isOneWay: Boolean,
    @SerializedName("is_refundable")
    val isRefundable: Boolean,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("origins")
    val origins: List<Origin>,
    @SerializedName("passenger_count")
    val passengerCount: Int,
    @SerializedName("passenger_servisable_count")
    val passengerServisableCount: Int,
    @SerializedName("provider")
    val provider: Any,
    @SerializedName("request_id")
    val requestİd: String,
    @SerializedName("return_date")
    val returnDate: Any,
    @SerializedName("senior")
    val senior: Int,
    @SerializedName("student")
    val student: Int,
    @SerializedName("version")
    val version: Int
){
    fun getFlightType():String{
        if (isOneWay==true){
            return "Tek Yön"
        }else{
            return "Çift Yön"
        }
    }

    fun passengerCount():String{
        return "${passengerCount}"
    }
}