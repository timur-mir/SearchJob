package home.howework.searchjob.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.searchjob.domain.GetOffersWorkCompaniesUseCase
import home.howework.searchjob.data.mocknetwork.model.OffersMain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val offersWorkCompaniesRepository: OffersWorkVacanciesImpl = OffersWorkVacanciesImpl(),
    private val remoteMockRepo: GetOffersWorkCompaniesUseCase = GetOffersWorkCompaniesUseCase(
        offersWorkCompaniesRepository
    )
) : ViewModel() {


    val data = OffersWorkCompaniesDto()
    private val _responseOffersVacancies = MutableStateFlow<OffersWorkCompaniesDto>(
        data
    )
    val responseOffersVacancies = _responseOffersVacancies.asStateFlow()
    val data2 = ArrayList<OffersMain>()

    private val _responseOffersMain = MutableStateFlow<List<OffersMain>>(
        data2
    )
    val responseOffersOffersMain = _responseOffersMain.asStateFlow()

    fun getOffersVacancies() {
        viewModelScope.launch {
            remoteMockRepo.getOffersVacancies { objectInfo ->
                _responseOffersVacancies.value = objectInfo
                val offersMain: MutableList<OffersMain> = mutableListOf(
                    OffersMain.VacanciesNear(
                        id = objectInfo.offers[0].id.toString(),
                        title = objectInfo.offers[0].title.toString(),
                        link = objectInfo.offers[0].link.toString(),
                    ),
                    OffersMain.ResumeRaise(
                        id = objectInfo.offers[1].id.toString(),
                        title = objectInfo.offers[1].title.toString(),
                        link = objectInfo.offers[1].link.toString(),
                    ),

                    OffersMain.TemporaryJob(
                        id = objectInfo.offers[2].id.toString(),
                        title = objectInfo.offers[2].title.toString(),
                        link = objectInfo.offers[2].link.toString(),
                    )
                )
                _responseOffersMain.value = offersMain
            }

        }
    }
}



