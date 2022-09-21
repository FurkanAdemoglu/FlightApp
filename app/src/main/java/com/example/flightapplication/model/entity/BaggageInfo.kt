package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class BaggageInfo(
    @SerializedName("carryOn")
    val carryOn: CarryOn,
    @SerializedName("firstBaggageCollection")
    val firstBaggageCollection: List<FirstBaggageCollection>
){
    fun getWeight():String{
        if (carryOn.allowance==8){
            return "El Bagajı"
        }else{
            return "20 kg / kişi"
        }
    }
}