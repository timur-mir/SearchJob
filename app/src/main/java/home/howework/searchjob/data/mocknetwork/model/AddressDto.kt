package home.howework.searchjob.data.mocknetwork.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class AddressDto(
   var town: String,
    var street: String,
    var house: String
):Parcelable