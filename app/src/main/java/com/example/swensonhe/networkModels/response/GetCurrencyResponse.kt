package com.example.swensonhe.networkModels.response

import com.google.gson.annotations.SerializedName

data class GetCurrencyResponse(
    @SerializedName("success") val success : Boolean,
    @SerializedName("timestamp") val timestamp : Int,
    @SerializedName("base") val base : String,
    @SerializedName("date") val date : String,
    @SerializedName("rates") val rates : Rates
) {

    data class Rates (
        @SerializedName("AED") val aED : Double,
        @SerializedName("AFN") val aFN : Double,
        @SerializedName("ALL") val aLL : Double,
        @SerializedName("AMD") val aMD : Double,
        @SerializedName("ANG") val aNG : Double,
        @SerializedName("AOA") val aOA : Double,
        @SerializedName("ARS") val aRS : Double,
        @SerializedName("AUD") val aUD : Double,
        @SerializedName("AWG") val aWG : Double,
        @SerializedName("AZN") val aZN : Double,
        @SerializedName("BAM") val bAM : Double,
        @SerializedName("BBD") val bBD : Double,
        @SerializedName("BDT") val bDT : Double,
        @SerializedName("BGN") val bGN : Double,

    )
}
