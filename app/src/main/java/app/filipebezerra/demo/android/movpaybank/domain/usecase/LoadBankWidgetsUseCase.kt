package app.filipebezerra.demo.android.movpaybank.domain.usecase

import app.filipebezerra.demo.android.movpaybank.data.BankRepository
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers

open class LoadBankWidgetsUseCase(
    private val bankRepository: BankRepository,
    dispatchers: AppCoroutineDispatchers
) : FlowUseCase<Unit, List<BankWidget>>(dispatchers) {

    override fun execute(params: Unit) = bankRepository.getWidgets()
}