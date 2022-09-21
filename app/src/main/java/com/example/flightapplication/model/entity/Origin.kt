package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Origin(
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
        if ( cityName.contains("\u011f")) {
            val validCityName=cityName.replace("\u011f","ğ")
            return validCityName
        }
        if ( cityName.contains("\u011e")) {
            val validCityName= cityName.replace("\u011e","Ğ")
            return validCityName
        }
        if ( cityName.contains("\u0131")) {
            val validCityName= cityName.replace("\u0131","ı")
            return validCityName
        }
        if ( cityName.contains( "\\u0130")){
            val validCityName=cityName.replace("\\u0130","İ")
            return validCityName
        }
        if ( cityName.contains("\u00f6")) {
            val validCityName = cityName.replace("\u00f6","ö")
            return validCityName
        }

        return cityName
    }
}