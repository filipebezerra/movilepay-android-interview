package app.filipebezerra.demo.android.movpaybank.util

import androidx.lifecycle.SavedStateHandle

const val CARD_ID_STATE_KEY = "cardId"

fun SavedStateHandle.getCardIdAsLiveData() = getLiveData<String>(CARD_ID_STATE_KEY)