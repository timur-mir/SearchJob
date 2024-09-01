package home.howework.searchjob.domain

import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.Vacancies

class GetOffersWorkCompaniesUseCase(private val offersWorkVacanciesImpl: OffersWorkVacanciesImpl) {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
       return offersWorkVacanciesImpl.getOffersVacancies(){
           callback(it)
       }
    }
}