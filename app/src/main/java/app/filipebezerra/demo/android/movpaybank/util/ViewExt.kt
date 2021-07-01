package app.filipebezerra.demo.android.movpaybank.util

import android.view.View
import androidx.core.view.isGone
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun View.isGone(isGone: Boolean) = let { view -> view.isGone = isGone  }