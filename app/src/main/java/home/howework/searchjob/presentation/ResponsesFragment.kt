package home.howework.searchjob.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.howework.searchjob.R
import home.howework.searchjob.databinding.FragmentResponsesBinding
import home.howework.searchjob.databinding.FullVacanciesFragmentBinding

class ResponsesFragment : Fragment() {
    private var _binding:FragmentResponsesBinding?= null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResponsesBinding.inflate(inflater)
        return binding.root
    }

}