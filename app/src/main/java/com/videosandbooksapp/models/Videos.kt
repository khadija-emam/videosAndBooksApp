package com.videosandbooksapp.models

import com.google.gson.annotations.SerializedName

data class  Videos (
    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("url") val url : String,
    @SerializedName("name") val name : String
    )
