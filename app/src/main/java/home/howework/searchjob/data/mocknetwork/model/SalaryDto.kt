package home.howework.searchjob.data.mocknetwork.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SalaryDto (
    var full : String
):Parcelable