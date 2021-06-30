package app.filipebezerra.demo.android.movpaybank.domain.usecase

import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard
import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers

data class GetBankCardUseCaseParams(
    val cardId: String
)

open class GetBankCardUseCase(
    private val bankRepository: BankRepository,
    dispatchers: AppCoroutineDispatchers
) : FlowUseCase<GetBankCardUseCaseParams, BankCard>(dispatchers) {

    override fun execute(parameters: GetBankCardUseCaseParams) =
        bankRepository.getCard(parameters.cardId)
}

fun String.asParams() = GetBankCardUseCaseParams(this)