package app.filipebezerra.demo.android.movpaybank.test.fakes

import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.data.source.remote.InvalidBankCardException
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class FakeBankDataSource(
    var widgets: List<BankWidget>? = mutableListOf(),
    var pairOfIdAndBankCard: Pair<String, BankCard>? = null
) : BankDataSource {

    override suspend fun getWidgets(): Result<List<BankWidget>> {
        widgets?.let { return Result.success(it) }
        return Result.failure(Exception("Test exception"))
    }

    override suspend fun getCard(id: String): Result<BankCard> {
        pairOfIdAndBankCard?.takeIf { it.first == id }?.let {
            return Result.success(it.second)
        }
        return Result.failure(InvalidBankCardException("Test exception:Invalid Bank card: $id"))
    }

    override fun getStatement(id: String): Flow<BankStatement> {
        TODO("Not yet implemented")
    }
}