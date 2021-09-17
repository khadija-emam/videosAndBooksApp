package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @GET("/movies")
    fun getVideos(): Single<List<Videos>>
    @GET
    @Streaming
    fun downloadFile(@Url url: String): Observable<Response<ResponseBody>>
}