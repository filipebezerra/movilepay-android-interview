package app.filipebezerra.demo.android.movpaybank.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.filipebezerra.demo.android.movpaybank.databinding.HomeFragmentBinding
import app.filipebezerra.demo.android.movpaybank.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
//            buttonCard.setOnClickListener {
//                findNavController().navigate(HomeFragmentDirections.fromHomeToBankCard())
//            }
//            buttonStatement.setOnClickListener {
//                findNavController().navigate(HomeFragmentDirections.fromHomeToBankStatement())
//            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}