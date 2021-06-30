package app.filipebezerra.demo.android.movpaybank

import android.app.Application
import app.filipebezerra.demo.android.movpaybank.data.di.dataModules
import app.filipebezerra.demo.android.movpaybank.domain.di.domainModules
import app.filipebezerra.demo.android.movpaybank.presentation.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MovPayBankApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startLoggingInDebugMode()
        startKoin()
    }

    private fun startLoggingInDebugMode() {
        BuildConfig.DEBUG.takeIf { it }?.run { Timber.plant(Timber.DebugTree()) }
    }

    private fun startKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.INFO)
            androidContext(this@MovPayBankApplication)
            modules(
                appModules,
                dataModules,
                domainModules,
                presentationModules
            )
        }
    }
}