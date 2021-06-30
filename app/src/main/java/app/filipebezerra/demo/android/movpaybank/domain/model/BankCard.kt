package app.filipebezerra.demo.android.movpaybank.domain.model

data class BankCard(
    val cardNumber: String,
    val cardName: String,
    val expirationDate: String,
    val availableLimit: String,
    val totalLimit: String
)
