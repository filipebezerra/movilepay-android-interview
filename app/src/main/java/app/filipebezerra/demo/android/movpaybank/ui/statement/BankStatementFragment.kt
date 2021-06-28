package app.filipebezerra.demo.android.movpaybank.ui.statement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import app.filipebezerra.demo.android.movpaybank.databinding.BankStatementFragmentBinding
import app.filipebezerra.demo.android.movpaybank.presentation.statement.StatementViewModel

class BankStatementFragment : Fragment() {

    private var _binding: BankStatementFragmentBinding? = null

    private val viewModel: StatementViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BankStatementFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}