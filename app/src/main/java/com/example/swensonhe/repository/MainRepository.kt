package com.example.swensonhe.repository

import com.example.swensonhe.api.ApiHelper
import org.koin.core.KoinComponent


class MainRepository(private val apiHelper: ApiHelper) : KoinComponent {


    suspend fun getCurrencyRepo() =
        apiHelper.getCurrency()
}