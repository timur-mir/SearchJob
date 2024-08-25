package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName
import home.howework.searchjob.entity.Offers

data class OffersDto(
    @SerializedName("id")
    var id: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("link")
    var link: String
)
