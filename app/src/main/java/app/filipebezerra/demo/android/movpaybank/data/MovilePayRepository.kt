package app.filipebezerra.demo.android.movpaybank.data

import app.filipebezerra.demo.android.movpaybank.data.source.BankDataSource
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovilePayRepository(private val bankDataSource: BankDataSource) : BankRepository {

    override fun getWidgets(): Flow<Result<List<BankWidget>>> = flow {
        emit(bankDataSource.getWidgets())
    }

    override fun getCard(id: String): Flow<Result<BankCard>> = flow {
        emit(bankDataSource.getCard(id))
    }

    override fun getStatement(id: String): Flow<Result<BankStatement>> {
        TODO("Not yet implemented")
    }
}