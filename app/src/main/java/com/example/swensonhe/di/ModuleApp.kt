package com.example.swensonhe.di
import com.example.swensonhe.repository.MainRepository
import com.example.swensonhe.api.ApiHelper
import com.example.swensonhe.api.RetrofitBuilder
import com.example.swensonhe.ui.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    factory { RetrofitBuilder.apiService }
    factory { ApiHelper(get()) }
    single { MainRepository(get()) }

}
val mainViewModel= module {
    viewModel { MainViewModel(get()) }
}
