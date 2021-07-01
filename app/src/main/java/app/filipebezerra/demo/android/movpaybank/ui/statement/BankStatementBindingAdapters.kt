package app.filipebezerra.demo.android.movpaybank.ui.statement

import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.filipebezerra.demo.android.movpaybank.domain.model.BankTransaction

@BindingAdapter("bankTransactions")
fun RecyclerView.bankTransactions(bankTransactions: List<BankTransaction>?) {
    if (bankTransactions?.isNotEmpty() == true) {
        isVisible = true
        adapter = (adapter as? BankTransactionAdapter ?: BankTransactionAdapter())
            .apply {
                transactions = bankTransactions
            }
    } else {
        isGone = true
    }
}