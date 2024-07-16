package com.naniak.githubapi.di


import com.naniak.githubapi.features.home.repository.HomeRepository
import com.naniak.githubapi.features.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.bind

val mainModule = module {

    viewModel { HomeViewModel() }


}