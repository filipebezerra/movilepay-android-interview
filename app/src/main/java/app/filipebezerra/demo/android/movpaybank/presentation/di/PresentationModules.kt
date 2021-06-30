package app.filipebezerra.demo.android.movpaybank.presentation.di

import app.filipebezerra.demo.android.movpaybank.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel { HomeViewModel(loadWidgetsUseCase = get()) }
}