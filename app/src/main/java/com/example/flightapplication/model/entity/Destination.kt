package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Destination(
    @SerializedName("airport_name")
    val airportName: String,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_city")
    val isCity: Boolean,
    @SerializedName("label")
    val label: String,
    @SerializedName("slug")
    val slug: String
){
    fun unicodeToTurkish():String{
        if ( cityName.contains("\u011f")) cityName.replace("\u011f","ğ")
        if ( cityName.contains("\u011e")) cityName.replace("\u011e","Ğ")
        if ( cityName.contains("\u0131")) cityName.replace("\u0131","ı")
        if ( cityName.contains( "\u0130")) cityName.replace("\u0130","İ")
        if ( cityName.contains("\u00f6")) cityName.replace("\u00f6","ö")
        return cityName
    }
}