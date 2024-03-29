package app.filipebezerra.demo.android.movpaybank.presentation.di

import app.filipebezerra.demo.android.movpaybank.presentation.card.BankCardViewModel
import app.filipebezerra.demo.android.movpaybank.presentation.home.HomeViewModel
import app.filipebezerra.demo.android.movpaybank.presentation.statement.BankStatementViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel { HomeViewModel(loadBankWidgetsUseCase = get()) }
    viewModel {
        BankCardViewModel(
            savedStateHandle = get(),
            getBankCardUseCase = get()
        )
    }
    viewModel {
        BankStatementViewModel(
            savedStateHandle = get(),
            getBankStatementUseCase = get()
        )
    }
}