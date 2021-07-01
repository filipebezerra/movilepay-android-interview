package app.filipebezerra.demo.android.movpaybank.ui.statement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.filipebezerra.demo.android.movpaybank.databinding.BankTransactionItemBinding
import app.filipebezerra.demo.android.movpaybank.domain.model.BankTransaction

class BankTransactionAdapter : RecyclerView.Adapter<BankTransactionViewHolder>() {

    var transactions = emptyList<BankTransaction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BankTransactionViewHolder.createFrom(parent)

    override fun onBindViewHolder(holder: BankTransactionViewHolder, position: Int) =
        holder.bindTo(transactions[position])

    override fun getItemCount() = transactions.size
}

class BankTransactionViewHolder private constructor(
    private val binding: BankTransactionItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindTo(item: BankTransaction) = with(binding) {
        label = item.label
        value = item.value
        description = item.description
        executePendingBindings()
    }

    companion object {
        fun createFrom(parent: ViewGroup) = BankTransactionViewHolder(
            BankTransactionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

