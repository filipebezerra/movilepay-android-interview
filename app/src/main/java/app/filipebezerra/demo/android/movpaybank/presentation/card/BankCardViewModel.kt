package app.filipebezerra.demo.android.movpaybank.presentation.card

import androidx.lifecycle.*
import app.filipebezerra.demo.android.movpaybank.domain.model.EmptyBankCard
import app.filipebezerra.demo.android.movpaybank.domain.usecase.GetBankCardUseCase
import app.filipebezerra.demo.android.movpaybank.domain.usecase.asParams
import app.filipebezerra.demo.android.movpaybank.util.getCardIdAsLiveData
import kotlinx.coroutines.flow.map

class BankCardViewModel(
    savedStateHandle: SavedStateHandle,
    getBankCardUseCase: GetBankCardUseCase
) : ViewModel() {

    private val cardId = savedStateHandle.getCardIdAsLiveData()

    private val bankCard = cardId.switchMap { id ->
        val params = id.asParams()
        getBankCardUseCase(params).map { result ->
            result.getOrDefault(EmptyBankCard)
        }.asLiveData()
    }

    val cardNumber = bankCard.map { it.cardNumber }
    val cardName = bankCard.map { it.cardName }
    val expirationDate = bankCard.map { it.expirationDate }

    // TODO: Should be used to show error message
    val invalidCardId = bankCard.map { it is EmptyBankCard }
}