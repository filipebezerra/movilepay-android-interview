package app.filipebezerra.demo.android.movpaybank.domain.usecase

import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, R>(
    private val dispatchers: AppCoroutineDispatchers
) {
    operator fun invoke(params: P): Flow<Result<R>> = execute(params)
        .flowOn(dispatchers.io)

    protected abstract fun execute(params: P): Flow<Result<R>>
}