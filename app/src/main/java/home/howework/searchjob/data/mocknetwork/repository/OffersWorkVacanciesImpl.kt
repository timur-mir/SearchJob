package home.howework.searchjob.data.mocknetwork.repository

import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.domain.OffersWorkCompaniesRepository

class OffersWorkVacanciesImpl:OffersWorkCompaniesRepository {
    private val mockRemoteDateSourceRepo= MockRemoteDataSourceRepo()
    override suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
       mockRemoteDateSourceRepo.getOffersVacancies(){it->callback(it)
        }
    }

}