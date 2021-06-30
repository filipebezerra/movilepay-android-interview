package app.filipebezerra.demo.android.movpaybank

import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModules = module {
    single {
        AppCoroutineDispatchers(
            io = Dispatchers.IO,
            computation = Dispatchers.Default,
            main = Dispatchers.Main
        )
    }
}