package app.filipebezerra.demo.android.movpaybank.domain.model

data class BankStatement(
    val balance: BankValue,
    val transactions: List<BankValue>
)
