package app.filipebezerra.demo.android.movpaybank.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import app.filipebezerra.demo.android.movpaybank.domain.usecase.LoadBankWidgetsUseCase
import kotlinx.coroutines.flow.map

class HomeViewModel(loadBankWidgetsUseCase: LoadBankWidgetsUseCase) : ViewModel() {

    val bankWidgets = loadBankWidgetsUseCase(Unit).map { it.getOrDefault(emptyList()) }.asLiveData()
}