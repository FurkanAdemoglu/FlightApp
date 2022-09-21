package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("code")
    val code: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
){
    fun unicodeToTurkish():String{
        if ( name.contains("\\u00fc")) {
            val validCityName=name.replace("\u011f","ü")
            return validCityName
        }
        if ( name.contains("\\u00dc")) {
            val validCityName= name.replace("\u011e","Ü")
            return validCityName
        }


        return name
    }
}