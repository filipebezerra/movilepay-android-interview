package app.filipebezerra.demo.android.movpaybank.util

import androidx.lifecycle.SavedStateHandle

const val CARD_ID_STATE_KEY = "cardId"

const val ACCOUNT_ID_STATE_KEY = "accountId"

fun SavedStateHandle.getCardIdAsLiveData() = getLiveData<String>(CARD_ID_STATE_KEY)

fun SavedStateHandle.getAccountIdAsLiveData() = getLiveData<String>(ACCOUNT_ID_STATE_KEY)