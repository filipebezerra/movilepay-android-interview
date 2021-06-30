package app.filipebezerra.demo.android.movpaybank.test

import app.filipebezerra.demo.android.movpaybank.util.AppCoroutineDispatchers
import kotlinx.coroutines.Dispatchers

val testCoroutineDispatchers = AppCoroutineDispatchers(
     io = Dispatchers.Main,
     computation = Dispatchers.Main,
     main = Dispatchers.Main
 )