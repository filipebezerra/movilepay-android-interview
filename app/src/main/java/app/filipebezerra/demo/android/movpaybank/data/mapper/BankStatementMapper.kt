package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankStatementDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankTransactionDto
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankTransaction

class BankStatementMapper(
    private val bankTransactionMapper: Mapper<BankTransactionDto, BankTransaction>
) : Mapper<BankStatementDto, BankStatement> {

    override suspend fun map(from: BankStatementDto) = BankStatement(
        balance = bankTransactionMapper.map(from.balance),
        transactions = from.transactions.map { bankTransactionMapper.map(it) }
    )
}