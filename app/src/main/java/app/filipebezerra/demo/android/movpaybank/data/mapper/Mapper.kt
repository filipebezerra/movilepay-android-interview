package app.filipebezerra.demo.android.movpaybank.data.mapper

interface Mapper<F, T> {
    suspend fun map(from: F): T
}