package app.filipebezerra.demo.android.movpaybank.domain.usecase

import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

open class LoadWidgetsUseCase(
    private val bankRepository: BankRepository,
    private val dispatchers: AppCoroutineDispatchers
) {
    operator fun invoke(): Flow<Result<List<BankWidget>>> = bankRepository.getWidgets()
        .flowOn(dispatchers.io)
}