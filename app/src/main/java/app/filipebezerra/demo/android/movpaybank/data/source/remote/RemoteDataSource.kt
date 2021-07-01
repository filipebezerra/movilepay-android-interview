package app.filipebezerra.demo.android.movpaybank.data.source.remote

import app.filipebezerra.demo.android.movpaybank.data.api.BankCardDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankService
import app.filipebezerra.demo.android.movpaybank.data.api.BankStatementDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetDto
import app.filipebezerra.demo.android.movpaybank.data.mapper.Mapper
import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget

class RemoteDataSource(
    private val params: RemoteDataSourceParams
) : BankDataSource {

    override suspend fun getWidgets(): Result<List<BankWidget>> = runCatching {
        params.bankService.getWidgets().widgets.map {
            params.bankWidgetMapper.map(it)
        }
    }

    override suspend fun getCard(cardId: String): Result<BankCard> = runCatching {
        params.bankService.getCard(cardId)?.let {
            params.bankCardMapper.map(it)
        } ?: throw InvalidBankCardException(cardId)
    }

    override suspend fun getStatement(accountId: String): Result<BankStatement> = runCatching {
        params.bankService.getStatement(accountId)?.let {
            params.bankStatementMapper.map(it)
        } ?: throw InvalidBankStatementException(accountId)
    }
}

data class RemoteDataSourceParams(
    val bankService: BankService,
    val bankWidgetMapper: Mapper<BankWidgetDto, BankWidget>,
    val bankCardMapper: Mapper<BankCardDto, BankCard>,
    val bankStatementMapper: Mapper<BankStatementDto, BankStatement>
)