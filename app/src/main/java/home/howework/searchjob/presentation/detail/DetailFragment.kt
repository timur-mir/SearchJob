package home.howework.searchjob.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import home.howework.searchjob.databinding.DetailFragmentBinding
import home.howework.searchjob.databinding.LoginFragmentBinding
import home.howework.searchjob.databinding.SearchFragmentBinding

class DetailFragment:Fragment() {
    private var _binding: DetailFragmentBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg: DetailFragmentArgs by navArgs()
        binding.isBack.setOnClickListener{
            findNavController().popBackStack()
        }
        binding.vacancy.text=arg.aboutVacancy.title
    }
}