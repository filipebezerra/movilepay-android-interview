package app.filipebezerra.demo.android.movpaybank.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import app.filipebezerra.demo.android.movpaybank.databinding.BankCardFragmentBinding
import app.filipebezerra.demo.android.movpaybank.presentation.card.BankCardViewModel
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class BankCardFragment : Fragment() {

    private var _binding: BankCardFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val arguments: BankCardFragmentArgs by navArgs()

    private val viewModel: BankCardViewModel by stateViewModel(state = { arguments.toBundle() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BankCardFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = this@BankCardFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}