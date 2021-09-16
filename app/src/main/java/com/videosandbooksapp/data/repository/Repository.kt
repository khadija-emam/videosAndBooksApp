package com.videosandbooksapp.data.repository

import com.videosandbooksapp.data.remotedatalayer.RemoteDataSource
import com.videosandbooksapp.models.Videos
import javax.inject.Inject

interface Repository {
fun getVideos():List<Videos>?
}

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):Repository{
    override fun getVideos() :List<Videos>?{
     return remoteDataSource.getVideos()
    }

}