package app.filipebezerra.demo.android.movpaybank.data

import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow

interface BankRepository {

    fun getWidgets(): Flow<Result<List<BankWidget>>>

    fun getCard(id: String): Flow<Result<BankCard>>

    fun getStatement(id: String): Flow<Result<BankStatement>>
}