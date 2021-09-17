package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import okhttp3.ResponseBody
import retrofit2.Response

interface RemoteDataSource {
     fun getVideos(): Single<List<Videos>>
     fun downloadVideo(url:String): Observable<Response<ResponseBody>>

}