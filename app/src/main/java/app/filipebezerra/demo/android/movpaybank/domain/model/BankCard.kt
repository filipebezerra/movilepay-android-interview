package app.filipebezerra.demo.android.movpaybank.domain.model

sealed interface IBankCard {
    val cardNumber: String
    val cardName: String
    val expirationDate: String
    val availableLimit: String
    val totalLimit: String
}

data class BankCard(
    override val cardNumber: String,
    override val cardName: String,
    override val expirationDate: String,
    override val availableLimit: String,
    override val totalLimit: String
) : IBankCard

object EmptyBankCard : IBankCard {
    override val cardNumber: String = ""
    override val cardName: String = ""
    override val expirationDate: String = ""
    override val availableLimit: String = ""
    override val totalLimit: String = ""
}