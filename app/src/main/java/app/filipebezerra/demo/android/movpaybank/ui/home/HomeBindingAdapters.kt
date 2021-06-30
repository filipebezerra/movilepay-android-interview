package app.filipebezerra.demo.android.movpaybank.ui.home

import android.text.Layout
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AlignmentSpan
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidgetButton
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidgetContent

@BindingAdapter("bankWidgets")
fun RecyclerView.bankWidgets(bankWidgets: List<BankWidget>?) {
    if (bankWidgets?.isNotEmpty() == true) {
        isVisible = true
        adapter = (adapter as? WidgetAdapter ?: WidgetAdapter())
            .apply {
                widgets = bankWidgets
            }
    } else {
        isGone = true
    }
}

@BindingAdapter("bankWidgetButton")
fun Button.bankWidgetButton(bankWidgetButton: BankWidgetButton?) {
    if (bankWidgetButton != null) {
        isVisible = true
        text = bankWidgetButton.text
    } else {
        isGone = true
    }
}

@BindingAdapter("bankWidgetContent")
fun TextView.bankWidgetContent(bankWidgetContent: BankWidgetContent) {
    when {
        bankWidgetContent.cardNumber != null -> text = bankWidgetContent.cardNumber
        bankWidgetContent.balance != null -> {
            text = with(bankWidgetContent.balance) { label + value }
        }
        else -> isGone = true
    }
}