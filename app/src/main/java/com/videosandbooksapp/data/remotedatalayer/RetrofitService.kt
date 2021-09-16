package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos
import io.reactivex.Single
import retrofit2.http.*

interface RetrofitService {

    @GET("/movies")
    fun getVideos(): Single<List<Videos>>

}