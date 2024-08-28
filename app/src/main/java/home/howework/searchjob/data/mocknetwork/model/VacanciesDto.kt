package home.howework.searchjob.data.mocknetwork.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
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
):Parcelable