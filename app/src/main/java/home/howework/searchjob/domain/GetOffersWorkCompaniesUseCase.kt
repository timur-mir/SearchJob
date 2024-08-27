package home.howework.searchjob.domain

import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.Vacancies

class GetOffersWorkCompaniesUseCase(private val offersWorkCompaniesRepository: OffersWorkCompaniesRepository) {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
       return offersWorkCompaniesRepository.getOffersVacancies(){
           callback(it)
       }
    }
}