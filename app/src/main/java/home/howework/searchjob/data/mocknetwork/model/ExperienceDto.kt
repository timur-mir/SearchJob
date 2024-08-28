package home.howework.searchjob.data.mocknetwork.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ExperienceDto(
    var previewText: String,
    var text: String
):Parcelable
