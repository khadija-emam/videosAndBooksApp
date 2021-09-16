package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos

interface RemoteDataSource {
     fun getVideos(): List<Videos>?

}