package app.filipebezerra.demo.android.movpaybank.data.source

import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow

interface BankDataSource {

    suspend fun getWidgets(): Result<List<BankWidget>>

    suspend fun getCard(id: String): Result<BankCard>

    fun getStatement(id: String): Flow<BankStatement>
}