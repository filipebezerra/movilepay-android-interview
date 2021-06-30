package app.filipebezerra.demo.android.movpaybank.data.di

import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.data.MovilePayRepository
import app.filipebezerra.demo.android.movpaybank.data.api.BankService
import app.filipebezerra.demo.android.movpaybank.data.api.SERVICE_API_URL
import app.filipebezerra.demo.android.movpaybank.data.mapper.BankWidgetMapper
import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.data.source.remote.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val dataModules = module {
    single<BankService> {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    HttpLoggingInterceptor.Level.BODY
            })
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

        Retrofit.Builder()
            .baseUrl(SERVICE_API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(BankService::class.java)
    }

    single<BankRepository> { MovilePayRepository(bankDataSource = get()) }

    single<BankDataSource> {
        RemoteDataSource(
            bankService = get(),
            bankWidgetMapper = BankWidgetMapper()
        )
    }
}