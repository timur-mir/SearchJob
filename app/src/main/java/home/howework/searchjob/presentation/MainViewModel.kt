package home.howework.searchjob.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.searchjob.domain.GetOffersWorkCompaniesUseCase
import home.howework.searchjob.domain.OffersWorkCompaniesRepository
import home.howework.searchjob.entity.Offers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val offersWorkCompaniesRepository = OffersWorkVacanciesImpl()
    val remoteMockRepo= GetOffersWorkCompaniesUseCase(offersWorkCompaniesRepository)

        private val _responseOffers = MutableStateFlow<List<OffersDto>>(emptyList<OffersDto>())
             val responseOffers = _responseOffers.asStateFlow()

    private val _responseVacancies = MutableStateFlow<List<VacanciesDto>>(emptyList<VacanciesDto>())
    val responseVacancies = _responseVacancies.asStateFlow()

    fun getOffers() {
        viewModelScope.launch {
            _responseOffers.value = remoteMockRepo.getOffers()
        }
    }
    fun getVacancies() {
        viewModelScope.launch {
            _responseVacancies.value =remoteMockRepo.getVacancies()
        }
    }

}