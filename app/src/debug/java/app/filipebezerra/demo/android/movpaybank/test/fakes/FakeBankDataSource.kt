package app.filipebezerra.demo.android.movpaybank.test.fakes

import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.data.source.remote.InvalidBankCardException
import app.filipebezerra.demo.android.movpaybank.data.source.remote.InvalidBankStatementException
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget

class FakeBankDataSource(
    var widgets: List<BankWidget>? = mutableListOf(),
    var pairOfIdAndBankCard: Pair<String, BankCard>? = null,
    var pairOfIdAndBankStatement: Pair<String, BankStatement>? = null,
) : BankDataSource {

    override suspend fun getWidgets(): Result<List<BankWidget>> {
        widgets?.let {
            return it.widgetsResult()
        }
        return Result.success(emptyList())
    }

    private fun List<BankWidget>.widgetsResult() = Result.success(this)

    override suspend fun getCard(cardId: String): Result<BankCard> {
        pairOfIdAndBankCard?.takeIf { it.isEqualTo(cardId) }?.let {
            return it.cardResult()
        }
        return Result.failure(InvalidBankCardException(cardId))
    }

    private fun Pair<String, BankCard>.cardResult() = Result.success(second)

    override suspend fun getStatement(accountId: String): Result<BankStatement> {
        pairOfIdAndBankStatement?.takeIf { it.isEqualTo(accountId) }?.let {
            return it.statementResult()
        }
        return Result.failure(InvalidBankStatementException(accountId))
    }

    private fun Pair<String, *>.isEqualTo(id: String) = first == id

    private fun Pair<String, BankStatement>.statementResult() = Result.success(second)
}