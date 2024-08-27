package home.howework.searchjob.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.repository.MockRemoteDataSourceRepo
import home.howework.searchjob.data.mocknetwork.repository.NetworkClient
import home.howework.searchjob.databinding.SearchFragmentBinding

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {
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
            lifecycleScope.launch {
                mainViewModel.getOffersVacancies()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            mainViewModel.getOffersVacancies()
            mainViewModel.responseOffersVacancies.onEach { list ->
                if (list != null) {
                    binding.searchBody.text = list.offers.toString() + list.vacancies.toString()
                } else {
                    binding.searchBody.text = "Приходит нуль${list}"
                }

            }.launchIn(this)

        }
    }

    override fun onResume() {
        super.onResume()

    }
}


