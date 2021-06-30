package app.filipebezerra.demo.android.movpaybank.data.source.remote

import app.filipebezerra.demo.android.movpaybank.data.api.BankCardDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankService
import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetDto
import app.filipebezerra.demo.android.movpaybank.data.mapper.Mapper
import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow

class RemoteDataSource(
    private val parameters: RemoteDataSourceParameter
) : BankDataSource {

    override suspend fun getWidgets(): Result<List<BankWidget>> = runCatching {
        parameters.bankService.getWidgets().widgets.map {
            parameters.bankWidgetMapper.map(it)
        }
    }

    override suspend fun getCard(id: String): Result<BankCard> = runCatching {
        parameters.bankService.getCard(id)?.let {
            parameters.bankCardMapper.map(it)
        } ?: throw InvalidBankCardException("Invalid Bank card: $id")
    }

    override fun getStatement(id: String): Flow<BankStatement> {
        TODO("Not yet implemented")
    }
}

data class RemoteDataSourceParameter(
    val bankService: BankService,
    val bankWidgetMapper: Mapper<BankWidgetDto, BankWidget>,
    val bankCardMapper: Mapper<BankCardDto, BankCard>
)