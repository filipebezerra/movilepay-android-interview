package app.filipebezerra.demo.android.movpaybank.test.fakes

import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class FakeBankDataSource(var widgets: List<BankWidget>? = mutableListOf()) : BankDataSource {

    override suspend fun getWidgets(): Result<List<BankWidget>> {
        widgets?.let { return Result.success(it) }
        return Result.failure(Exception("Test exception"))
    }

    override fun getCard(id: String): Flow<BankCard> {
        TODO("Not yet implemented")
    }

    override fun getStatement(id: String): Flow<BankStatement> {
        TODO("Not yet implemented")
    }
}