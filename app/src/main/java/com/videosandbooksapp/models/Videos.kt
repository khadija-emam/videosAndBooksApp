package com.videosandbooksapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Videos (
    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("url") val url : String,
    @SerializedName("name") val name : String
    ):Parcelable
