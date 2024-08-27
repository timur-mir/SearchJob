package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName


data class VacanciesDto(
    var id: String,
    var lookingNumber: Int,
    var title: String,
    var address: AddressDto,
    var company: String,
    var experience: ExperienceDto,
    var publishedDate: String,
    var isFavorite: Boolean,
    var salary: SalaryDto,
    var schedules: ArrayList<String> = arrayListOf(),
    var appliedNumber    : Int,
    var description: String,
    var responsibilities: String,
    var questions: ArrayList<String> = arrayListOf()
)