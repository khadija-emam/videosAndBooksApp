package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {

    @POST("https://nagwa.free.beeceptor.com/movies")
    @Headers("Content-Type: application/x-www-form-urlencoded ", "Accept: application/json")
    @FormUrlEncoded
    fun getVideos(): Response<List<Videos>>

}