package home.howework.searchjob.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import home.howework.searchjob.databinding.SearchFragmentBinding
import home.howework.searchjob.presentation.Help.responseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchFragment:Fragment() {
    private var _binding: SearchFragmentBinding? = null
    val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getOffers.setOnClickListener() {
            mainViewModel.getOffers()
            mainViewModel.getVacancies()
            lifecycleScope.launch(Dispatchers.Main) {
                mainViewModel.responseOffers.collect() { offersList ->
                    responseData = offersList.toString()
                    mainViewModel.responseVacancies.collect() { offersList2 ->
                        responseData = responseData + offersList2.toString()
                        binding.searchBody.text = responseData
                    }
                }
            }
        }
    }
}


object Help{
    var responseData=""
}