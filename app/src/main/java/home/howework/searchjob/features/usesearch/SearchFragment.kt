package home.howework.searchjob.features.usesearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import home.howework.searchjob.databinding.SearchFragmentBinding
import home.howework.searchjob.features.usesearch.adapters.OffersMainAdapter
import home.howework.searchjob.Utilts.ItemOffsetDecoration
import home.howework.searchjob.features.usesearch.adapters.VacanciesAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: SearchFragmentBinding? = null
    val binding get() = _binding!!
    private val vacanciesAdapter =
        VacanciesAdapter { vacancy->  }
    private val offersMainAdapter =
        OffersMainAdapter { link ->
            Toast.makeText(requireContext(),"Переход на сайт:$link",Toast.LENGTH_LONG).show()
            val browserIntent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            browserIntent.data=Uri.parse(link)
            startActivity(browserIntent)
        }

    private val mainViewModel: home.howework.presentation.vm.MainViewModel by viewModels()
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
        with(binding.vacancies3) {
            adapter = vacanciesAdapter
            setHasFixedSize(true)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        with(binding.topOffers) {
          adapter = offersMainAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
                setHasFixedSize(true)
                addItemDecoration(ItemOffsetDecoration(requireContext()))
            }
        }
        binding.getAllVacancies.setOnClickListener{
            val action = SearchFragmentDirections.actionSearchFragment2ToFullVacanciesFragment()
            findNavController().navigate(action)
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            mainViewModel.getOffersVacancies()
            mainViewModel.responseOffersOffersMain.onEach { list ->
                   offersMainAdapter.items = list
            }.launchIn(this)
            mainViewModel.responseOffersVacancies.onEach { list ->
                val listVacancies=list.vacancies
                binding.getAllVacancies.text="Ещё ${listVacancies.size-3} вакансии"
                vacanciesAdapter.submitList(listVacancies.take(3))
            }.launchIn(this)

        }
    }

    override fun onResume() {
        super.onResume()

    }
}


