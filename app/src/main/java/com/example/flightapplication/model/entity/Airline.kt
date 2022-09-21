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

    fun unicodeToTurkishForFlight(flightCompany:String):String{
        var validCityName=""
        if ( flightCompany.contains("\\u011f")) {
            validCityName=flightCompany.replace("\\u011f","ğ")

        }
        if ( flightCompany.contains("\\u011e")) {
            validCityName= flightCompany.replace("\\u011e","Ğ")

        }
        if ( flightCompany.contains("\\u0131")) {
            validCityName= flightCompany.replace("\\u0131","ı")

        }
        if ( flightCompany.contains( "\\u0130")){
            validCityName=flightCompany.replace("\\u0130","İ")
        }
        if ( flightCompany.contains("\\u00f6")) {
            validCityName = flightCompany.replace("\\u00f6","ö")

        }
        if ( flightCompany.contains("\\u00fc")) {
             validCityName = flightCompany.replace("\\u00fc","ü")
        }
        if (validCityName.isNullOrEmpty()){
            return  flightCompany
        }else{
            return validCityName
        }
    }
}