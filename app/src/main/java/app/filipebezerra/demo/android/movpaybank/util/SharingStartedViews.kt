package app.filipebezerra.demo.android.movpaybank.util

import kotlinx.coroutines.flow.SharingStarted

private const val STOP_TIME_OUT_MILLIS: Long = 5000

val WhileViewSubscribed = SharingStarted.WhileSubscribed(STOP_TIME_OUT_MILLIS)