package home.howework.searchjob.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import home.howework.searchjob.databinding.LoginFragmentBinding

class LoginFragment:Fragment() {
    private var _binding: LoginFragmentBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextAction.setOnClickListener{
          val action = LoginFragmentDirections.actionLoginFragmentToConfirmationFragment()
            findNavController().navigate(action)
        }
    }

}