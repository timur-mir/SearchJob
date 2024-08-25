package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName
import home.howework.searchjob.entity.Offers
import home.howework.searchjob.entity.OffersWorkCompanies
import home.howework.searchjob.entity.Vacancies

data class OffersWorkCompaniesDto(
    @SerializedName("offers")
     var offers: ArrayList<OffersDto>,
    @SerializedName("vacancies")
   var vacancies: ArrayList<VacanciesDto>
)