package com.videosandbooksapp.data.remotedatalayer

import com.videosandbooksapp.models.Videos
import io.reactivex.Single
import io.reactivex.SingleObserver

interface RemoteDataSource {
     fun getVideos(): Single<List<Videos>>

}