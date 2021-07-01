package app.filipebezerra.demo.android.movpaybank.domain.model

data class BankStatement(
    val balance: BankTransaction,
    val transactions: List<BankTransaction>
)
