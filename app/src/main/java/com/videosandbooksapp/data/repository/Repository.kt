package com.videosandbooksapp.data.repository

import com.videosandbooksapp.data.remotedatalayer.RemoteDataSource
import com.videosandbooksapp.models.Videos
import io.reactivex.Single
import io.reactivex.SingleObserver
import javax.inject.Inject

interface Repository {
fun getVideos(): Single<List<Videos>>
}

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):Repository{
    override fun getVideos() :Single<List<Videos>>{
     return remoteDataSource.getVideos()
    }

}