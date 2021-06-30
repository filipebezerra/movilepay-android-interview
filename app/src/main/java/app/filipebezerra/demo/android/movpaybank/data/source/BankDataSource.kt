package app.filipebezerra.demo.android.movpaybank.data.source

import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow

interface BankDataSource {

    suspend fun getWidgets(): Result<List<BankWidget>>

    fun getCard(id: String): Flow<BankCard>

    fun getStatement(id: String): Flow<BankStatement>
}