package com.example.swensonhe.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swensonhe.networkModels.response.GetCurrencyResponse
import com.example.swensonhe.repository.MainRepository
import com.example.swensonhe.util.Resource

import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val currency = MutableLiveData<Resource<GetCurrencyResponse>>()
    fun getCurrency(): LiveData<Resource<GetCurrencyResponse>> {
        return currency
    }

    fun getCurrencyTokenFromWebServices() {
        viewModelScope.launch {
            currency.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getCurrencyRepo()
                currency.postValue(Resource.success(data = response))

            } catch (exception: Exception) {

                currency.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!$exception"
                    )
                )
            }
        }
    }
}