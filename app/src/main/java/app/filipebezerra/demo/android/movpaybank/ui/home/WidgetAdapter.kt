package app.filipebezerra.demo.android.movpaybank.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.filipebezerra.demo.android.movpaybank.databinding.BankWidgetItemBinding
import app.filipebezerra.demo.android.movpaybank.domain.model.BankWidget

class WidgetAdapter : RecyclerView.Adapter<BankWidgetViewHolder>() {

    var widgets = emptyList<BankWidget>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BankWidgetViewHolder.createFrom(parent)

    override fun onBindViewHolder(holder: BankWidgetViewHolder, position: Int) =
        holder.bindTo(widgets[position])

    override fun getItemCount() = widgets.size
}

class BankWidgetViewHolder private constructor(
    private val binding: BankWidgetItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindTo(item: BankWidget) = with(binding) {
        widget = item
        executePendingBindings()
    }

    companion object {
        fun createFrom(parent: ViewGroup) = BankWidgetViewHolder(
            BankWidgetItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

