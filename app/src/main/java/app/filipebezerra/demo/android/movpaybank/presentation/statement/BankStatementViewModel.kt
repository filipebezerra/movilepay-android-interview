package app.filipebezerra.demo.android.movpaybank.presentation.statement

import androidx.lifecycle.*
import app.filipebezerra.demo.android.movpaybank.domain.model.BankStatement
import app.filipebezerra.demo.android.movpaybank.domain.usecase.GetBankStatementUseCase
import app.filipebezerra.demo.android.movpaybank.domain.usecase.GetBankStatementUseCaseParams
import app.filipebezerra.demo.android.movpaybank.util.WhileViewSubscribed
import app.filipebezerra.demo.android.movpaybank.util.getAccountIdAsLiveData
import kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class BankStatementViewModel(
    savedStateHandle: SavedStateHandle,
    getBankStatementUseCase: GetBankStatementUseCase
) : ViewModel() {

    private val accountId = savedStateHandle.getAccountIdAsLiveData()

    private val bankStatement = accountId.switchMap { id ->
        val params = GetBankStatementUseCaseParams(id)
        getBankStatementUseCase(params)
            .onStart { _dataLoading.value = true }
            .onEach { result ->
                _dataLoading.value = false
                result.tryHandleIfFailed()
            }
            .map { it.getOrThrow() }
            .asLiveData()
    }

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _errorMessage = Channel<String>(1, DROP_LATEST)
    val errorMessage: Flow<String> = _errorMessage.receiveAsFlow()
        .shareIn(viewModelScope, WhileViewSubscribed)

    val balanceLabel = bankStatement.map { it.balance.label }
    val balanceValue = bankStatement.map { it.balance.value }
    val transactions = bankStatement.map { it.transactions }

    private fun Result<BankStatement>.tryHandleIfFailed() {
        if (isFailure) {
            exceptionOrNull()?.let { exception ->
                _errorMessage.trySend(exception.message
                    ?: "Error getting statement"
                ).isSuccess
            }
        }
    }
}