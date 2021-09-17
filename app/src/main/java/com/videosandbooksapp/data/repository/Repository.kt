package com.videosandbooksapp.data.repository

import com.videosandbooksapp.data.remotedatalayer.RemoteDataSource
import com.videosandbooksapp.models.Videos
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

interface Repository {
    fun getVideos(): Single<List<Videos>>
    fun downloadFile(url: String): Observable<Response<ResponseBody>>
}

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):Repository{
    override fun getVideos() :Single<List<Videos>>{
     return remoteDataSource.getVideos()
    }

    override fun downloadFile(url: String): Observable<Response<ResponseBody>> {
        return remoteDataSource.downloadVideo(url)
    }

}