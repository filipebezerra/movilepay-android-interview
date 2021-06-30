package app.filipebezerra.demo.android.movpaybank.data.api

import retrofit2.http.GET
import retrofit2.http.Path

const val SERVICE_API_URL = "https://mpay-android-interview.herokuapp.com/android/interview/"

interface BankService {

    @GET("home")
    suspend fun getWidgets(): BankWidgetsResponse

    @GET("card/{id}")
    suspend fun getCard(@Path("id") id: String): BankCardDto?

    @GET("statement/{id}")
    suspend fun getStatement(@Path("id") id: String): BankStatementDto
}