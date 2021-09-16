package com.videosandbooksapp.data.remotedatalayer

import com.google.gson.Gson
import com.videosandbooksapp.models.Videos
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val retrofitService: RetrofitService):RemoteDataSource {
    override fun getVideos(): List<Videos>? {
        val response = retrofitService.getVideos()
        return if (response.isSuccessful) {
            if (response.body().isNullOrEmpty()) {
                response.body()

            } else {
                emptyList()
            }
        } else {

            throw Exception(response.message())
        }
    }

}