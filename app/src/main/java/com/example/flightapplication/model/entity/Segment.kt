package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Segment(
    @SerializedName("arrival_datetime")
    val arrivalDatetime: ArrivalDatetime,
    @SerializedName("available_seats")
    val availableSeats: Int,
    @SerializedName("class")
    val classX: String,
    @SerializedName("departure_datetime")
    val departureDatetime: DepartureDatetime,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("destination_terminal")
    val destinationTerminal: String,
    @SerializedName("display_arrival_datetime")
    val displayArrivalDatetime: String,
    @SerializedName("display_departure_datetime")
    val displayDepartureDatetime: String,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("flight_number")
    val flightNumber: String,
    @SerializedName("is_train")
    val isTrain: Boolean,
    @SerializedName("is_virtual_interlining")
    val isVirtualİnterlining: Boolean,
    @SerializedName("marketing_airline")
    val marketingAirline: String,
    @SerializedName("operating_airline")
    val operatingAirline: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("origin_terminal")
    val originTerminal: String,
    @SerializedName("segment_attributes")
    val segmentAttributes: SegmentAttributes,
    @SerializedName("segment_delay")
    val segmentDelay: SegmentDelay
)