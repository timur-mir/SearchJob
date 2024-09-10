package home.howework.domain

import home.howework.domain.entities.OffersWorkCompaniesDto
import javax.inject.Inject

class GetOffersWorkCompaniesUseCase  @Inject constructor(private val offersWorkCompaniesRepository:OffersWorkCompaniesRepository) {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
       return offersWorkCompaniesRepository.getOffersVacancies(){
           callback(it)
       }
    }
}