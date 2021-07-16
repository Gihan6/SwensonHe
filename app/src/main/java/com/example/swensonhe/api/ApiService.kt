package com.example.swensonhe.api

import com.example.swensonhe.networkModels.response.GetCurrencyResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("latest?access_key=ce6338abbc0804f7163c5d06f204de7d")
    suspend fun getCurrency(): GetCurrencyResponse
}