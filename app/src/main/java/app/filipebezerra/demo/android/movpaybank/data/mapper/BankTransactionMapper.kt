package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankTransactionDto
import app.filipebezerra.demo.android.movpaybank.domain.model.BankTransaction

class BankTransactionMapper : Mapper<BankTransactionDto, BankTransaction> {

    override suspend fun map(from: BankTransactionDto) = BankTransaction(
        label = from.label,
        value = from.value,
        description = from.description
    )
}