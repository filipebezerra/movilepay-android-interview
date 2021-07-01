package app.filipebezerra.demo.android.movpaybank.domain.model

data class BankTransaction(
    val label: String,
    val value: String,
    val description: String? = null
)
