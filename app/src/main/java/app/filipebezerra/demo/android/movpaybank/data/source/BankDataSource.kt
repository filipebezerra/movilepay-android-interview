package app.filipebezerra.demo.android.movpaybank.data.source

import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget

interface BankDataSource {

    suspend fun getWidgets(): Result<List<BankWidget>>

    suspend fun getCard(cardId: String): Result<BankCard>

    suspend fun getStatement(accountId: String): Result<BankStatement>
}