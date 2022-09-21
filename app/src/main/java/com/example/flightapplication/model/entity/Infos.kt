package com.example.flightapplication.model.entity


import com.google.gson.annotations.SerializedName

data class Infos(
    @SerializedName("active_warning")
    val activeWarning: Any,
    @SerializedName("baggage_info")
    val baggageİnfo: BaggageInfo,
    @SerializedName("duration")
    val duration: Duration,
    @SerializedName("is_business")
    val isBusiness: Boolean,
    @SerializedName("is_mask_required")
    val isMaskRequired: Boolean,
    @SerializedName("is_promo")
    val isPromo: Boolean,
    @SerializedName("is_reservable")
    val isReservable: Boolean,
    @SerializedName("is_virtual_interlining")
    val isVirtualİnterlining: Boolean
)