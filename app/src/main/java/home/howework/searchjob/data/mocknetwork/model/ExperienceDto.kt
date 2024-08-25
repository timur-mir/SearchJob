package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName
import home.howework.searchjob.entity.Experience

data class ExperienceDto(
    @SerializedName("previewText")
 var previewText: String,
    @SerializedName("text")
   var text: String)
