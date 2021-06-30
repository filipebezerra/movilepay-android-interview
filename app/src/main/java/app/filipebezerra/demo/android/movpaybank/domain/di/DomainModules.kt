package app.filipebezerra.demo.android.movpaybank.domain.di

import app.filipebezerra.demo.android.movpaybank.domain.usecase.LoadWidgetsUseCase
import org.koin.dsl.module

val domainModules = module {
    factory {
        LoadWidgetsUseCase(
            bankRepository = get(),
            dispatchers = get()
        )
    }
}