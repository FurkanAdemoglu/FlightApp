package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class BaggageInfo(
    @SerializedName("carryOn")
    val carryOn: CarryOn,
    @SerializedName("firstBaggageCollection")
    val firstBaggageCollection: List<FirstBaggageCollection>
){
    fun getWeight():String{

        if (firstBaggageCollection.isNullOrEmpty().not()){
            if (firstBaggageCollection.getOrNull(0)?.allowance!=8){
                return "${firstBaggageCollection.getOrNull(0)?.allowance} ${firstBaggageCollection.getOrNull(0)?.unit}/Kişi"
            }else{
                return "El Bagajı"
            }
        }else{
            return "El Bagajı"
        }

    }
}