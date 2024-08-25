package home.howework.searchjob.domain

import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto


interface OffersWorkCompaniesRepository {
    fun getOffers(): List<OffersDto>
    fun getVacancies(): List<VacanciesDto>
}