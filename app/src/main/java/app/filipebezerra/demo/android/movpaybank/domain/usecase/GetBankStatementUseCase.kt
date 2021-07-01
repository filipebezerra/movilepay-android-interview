package app.filipebezerra.demo.android.movpaybank.domain.usecase

import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers

data class GetBankStatementUseCaseParams(
    val accountId: String
)

open class GetBankStatementUseCase(
    private val bankRepository: BankRepository,
    dispatchers: AppCoroutineDispatchers
) : FlowUseCase<GetBankStatementUseCaseParams, BankStatement>(dispatchers) {

    override fun execute(params: GetBankStatementUseCaseParams) =
        bankRepository.getStatement(params.accountId)
}