package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val retrofitService: RetrofitService):RemoteDataSource {
    override fun getVideos(): Single<List<Videos>> {
        return retrofitService.getVideos()
    }

    override fun downloadVideo(url: String): Observable<Response<ResponseBody>> {
        return retrofitService.downloadFile(url)
    }


}