package home.howework.searchjob.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import home.howework.searchjob.R
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.databinding.FullVacanciesFragmentBinding
import home.howework.searchjob.presentation.Utilts.ItemOffsetDecoration
import home.howework.searchjob.presentation.VacanciesAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FullVacanciesFragment: Fragment() {
    private var _binding: FullVacanciesFragmentBinding? = null
    val binding get() = _binding!!
    private val vacanciesAdapter =
        VacanciesAdapter { idVacant -> toDetail(idVacant) }


    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FullVacanciesFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.fullVacancies) {
            adapter = vacanciesAdapter
            setHasFixedSize(true)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        val img = context?.let { AppCompatResources.getDrawable(it, R.drawable.arrow) }
        binding.fullSearchVacant.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
        binding.fullSearchVacant.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View?, event: MotionEvent?): Boolean {
                val DRAWABLE_LEFT=0
                val DRAWABLE_TOP=1
                val DRAWABLE_RIGHT=2
                val DRAWABLE_BOTTOM=3
                if(event!!.action == MotionEvent.ACTION_UP){
                    if(binding.fullSearchVacant.compoundDrawables[DRAWABLE_LEFT]!=null) {
                        if ( binding.fullSearchVacant.compoundDrawables[DRAWABLE_LEFT].bounds.width() >= event.rawX -  binding.fullSearchVacant.left ) {
                           findNavController().popBackStack()
                            return true
                        }
                    }
                }
                return false
            }

        })
    }
    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            mainViewModel.getOffersVacancies()
            mainViewModel.responseOffersVacancies.onEach { list ->
                vacanciesAdapter.submitList(list.vacancies)
                binding.vacanciesAmount.text="${list.vacancies.size} вакансий"
            }.launchIn(this)

        }
    }
    private fun toDetail(vacancy: VacanciesDto) {
        val action = FullVacanciesFragmentDirections.actionFullVacanciesFragmentToDetailFragment(vacancy)
        findNavController().navigate(action)

    }
}