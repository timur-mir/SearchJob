package home.howework.searchjob.domain

import home.howework.searchjob.data.mocknetwork.model.OffersDto
import home.howework.searchjob.data.mocknetwork.model.OffersWorkCompaniesDto
import home.howework.searchjob.data.mocknetwork.model.VacanciesDto
import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.Vacancies
import javax.security.auth.callback.Callback


interface OffersWorkCompaniesRepository {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit)
}