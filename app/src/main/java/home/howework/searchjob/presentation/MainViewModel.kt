package home.howework.searchjob.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.searchjob.domain.GetOffersWorkCompaniesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val offersWorkCompaniesRepository = OffersWorkVacanciesImpl()
    val remoteMockRepo = GetOffersWorkCompaniesUseCase(offersWorkCompaniesRepository)

   val data = OffersWorkCompaniesDto()
    private val _responseOffersVacancies = MutableStateFlow<OffersWorkCompaniesDto>(
      data
    )
    val responseOffersVacancies = _responseOffersVacancies.asStateFlow()

    fun getOffersVacancies() {
        viewModelScope.launch {
            remoteMockRepo.getOffersVacancies { objectInfo->
                _responseOffersVacancies.value=objectInfo
            }

        }
    }
}



