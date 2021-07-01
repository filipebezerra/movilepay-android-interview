package app.filipebezerra.demo.android.movpaybank.ui.statement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import app.filipebezerra.demo.android.movpaybank.databinding.BankStatementFragmentBinding
import app.filipebezerra.demo.android.movpaybank.presentation.statement.BankStatementViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class BankStatementFragment : Fragment() {

    private var _binding: BankStatementFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val arguments: BankStatementFragmentArgs by navArgs()

    private val viewModel: BankStatementViewModel by stateViewModel(state = { arguments.toBundle() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BankStatementFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = this@BankStatementFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.errorMessage.flowWithLifecycle(lifecycle)
                .collect {
                    Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
                        .show()
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}