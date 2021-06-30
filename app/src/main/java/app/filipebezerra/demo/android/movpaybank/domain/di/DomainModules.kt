package app.filipebezerra.demo.android.movpaybank.domain.di

import app.filipebezerra.demo.android.movpaybank.domain.usecase.GetBankCardUseCase
import app.filipebezerra.demo.android.movpaybank.domain.usecase.LoadBankWidgetsUseCase
import org.koin.dsl.module

val domainModules = module {
    factory {
        LoadBankWidgetsUseCase(
            bankRepository = get(),
            dispatchers = get()
        )
    }
    factory {
        GetBankCardUseCase(
            bankRepository = get(),
            dispatchers = get()
        )
    }
}