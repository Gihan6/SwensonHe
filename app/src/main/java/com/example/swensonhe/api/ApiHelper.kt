package com.example.swensonhe.api



class ApiHelper (private val apiService: ApiService) {
    suspend fun getCurrency() = apiService.getCurrency()
}