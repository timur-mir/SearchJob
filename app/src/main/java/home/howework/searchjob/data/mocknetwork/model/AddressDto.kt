package home.howework.searchjob.data.mocknetwork.model

import com.google.gson.annotations.SerializedName
import home.howework.searchjob.entity.Address

data class AddressDto(
    @SerializedName("town")
   var town: String,
    @SerializedName("street")
   var street: String,
    @SerializedName("house")
   var house: String
)