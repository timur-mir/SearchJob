package home.howework.searchjob.data.mocknetwork.repository

import home.howework.searchjob.data.mocknetwork.MockRemoteDateSource
import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.domain.OffersWorkCompaniesRepository
import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.Vacancies

class OffersWorkVacanciesImpl:OffersWorkCompaniesRepository {
    private val mockRemoteDateSource= MockRemoteDateSource()
    override  fun getOffers(): List<OffersDto> {
        return mockRemoteDateSource.getOffers()
    }

    override  fun getVacancies(): List<VacanciesDto> {
        return mockRemoteDateSource.getVacancies()
    }
}