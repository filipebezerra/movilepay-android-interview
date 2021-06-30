package app.filipebezerra.demo.android.movpaybank.data.source.remote

import app.filipebezerra.demo.android.movpaybank.data.api.BankService
import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetDto
import app.filipebezerra.demo.android.movpaybank.data.mapper.Mapper
import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow

class RemoteDataSource(
    private val bankService: BankService,
    private val bankWidgetMapper: Mapper<BankWidgetDto, BankWidget>
) : BankDataSource {

    override suspend fun getWidgets(): Result<List<BankWidget>> = runCatching {
        bankService.getWidgets().widgets.map {
            bankWidgetMapper.map(it)
        }
    }

    override fun getCard(id: String): Flow<BankCard> {
        TODO("Not yet implemented")
    }

    override fun getStatement(id: String): Flow<BankStatement> {
        TODO("Not yet implemented")
    }
}