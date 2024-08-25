package home.howework.searchjob.domain

import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.Vacancies

class GetOffersWorkCompaniesUseCase(private val offersWorkCompaniesRepository: OffersWorkCompaniesRepository) {
   init {

    }
    fun getOffers():List<OffersDto>{
       return offersWorkCompaniesRepository.getOffers()
    }
   fun getVacancies():List<VacanciesDto>{
        return offersWorkCompaniesRepository.getVacancies()
    }
}