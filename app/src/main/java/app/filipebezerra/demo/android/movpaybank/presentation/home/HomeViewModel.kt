package app.filipebezerra.demo.android.movpaybank.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import app.filipebezerra.demo.android.movpaybank.domain.usecase.LoadWidgetsUseCase
import kotlinx.coroutines.flow.map

class HomeViewModel(loadWidgetsUseCase: LoadWidgetsUseCase) : ViewModel() {

    val bankWidgets = loadWidgetsUseCase().map { it.getOrDefault(emptyList()) }.asLiveData()
}