package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName
import home.howework.searchjob.entity.Address
import home.howework.searchjob.entity.Experience
import home.howework.searchjob.entity.Salary
import home.howework.searchjob.entity.Vacancies

data class VacanciesDto(
    @SerializedName("id")
  var id: String,
    @SerializedName("lookingNumber")
  var lookingNumber: Int,
    @SerializedName("title")
  var title: String,
    @SerializedName("address")
  var address: AddressDto,
    @SerializedName("company")
  var company: String,
    @SerializedName("experience")
  var experience: ExperienceDto,
    @SerializedName("publishedDate")
  var publishedDate: String,
    @SerializedName("isFavorite")
  var isFavorite: Boolean,
    @SerializedName("salary")
  var salary: SalaryDto,
    @SerializedName("schedules")
  var schedules: ArrayList<String>,
    @SerializedName("appliedNumber")
  var appliedNumber: Int,
    @SerializedName("description")
  var description: String,
    @SerializedName("responsibilities")
  var responsibilities: String,
    @SerializedName("questions")
  var questions: ArrayList<String>
)
