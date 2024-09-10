package home.howework.searchjob.features.usevacancies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import home.howework.data.mocknetwork.model.VacanciesResponse
import home.howework.domain.entities.VacanciesDto
import home.howework.searchjob.R
import home.howework.searchjob.databinding.FullVacanciesFragmentBinding
import home.howework.searchjob.Utilts.ItemOffsetDecoration
import home.howework.searchjob.features.usesearch.adapters.VacanciesAdapter

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FullVacanciesFragment: Fragment() {
    private var _binding: FullVacanciesFragmentBinding? = null
    val binding get() = _binding!!
    private val vacanciesAdapter =
        VacanciesAdapter { idVacant -> toDetail(idVacant) }


    private val mainViewModel: home.howework.presentation.vm.MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FullVacanciesFragmentBinding.inflate(inflater)
        return binding.root
    }
    @SuppressLint("ClickableViewAccessibility")
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
                vacanciesAdapter.submitList(list.vacancies )
                binding.vacanciesAmount.text="${list.vacancies.size} вакансий"
            }.launchIn(this)

        }
    }
    private fun toDetail(vacancy: VacanciesDto) {
        val action =
            FullVacanciesFragmentDirections.actionFullVacanciesFragmentToDetailFragment(vacancy)
        findNavController().navigate(action)

    }
//      vacanciesAdapter.submitList(list.vacancies.map { it->VacanciesResponse(id = it.id, lookingNumber = it.lookingNumber,
//                    title = it.title, address = it.address, company =it.company, experience = it.experience,
//                    publishedDate = it.publishedDate, isFavorite = it.isFavorite, salary = it.salary, schedules = it.schedules,
//                    appliedNumber = it.appliedNumber, description = it.description, responsibilities = it.responsibilities, questions = it.questions
//                ) })
}