package com.videosandbooksapp.data.repository

import javax.inject.Inject

interface Repository {
fun getVideos()
}

class RepositoryImpl @Inject constructor():Repository{
    override fun getVideos() {
        TODO("Not yet implemented")
    }

}