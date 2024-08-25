package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName
import home.howework.searchjob.entity.Salary

data class SalaryDto(
    @SerializedName("full" )
    var full : String
)