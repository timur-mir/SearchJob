package home.howework.searchjob.data.mocknetwork.model

import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.OffersWorkCompanies
import home.howework.searchjob.entity.Vacancies
import com.google.gson.annotations.SerializedName

data class OffersWorkCompaniesDto(
      var offers    : ArrayList<OffersDto> = arrayListOf(),
      var vacancies :ArrayList<VacanciesDto> = arrayListOf()
)