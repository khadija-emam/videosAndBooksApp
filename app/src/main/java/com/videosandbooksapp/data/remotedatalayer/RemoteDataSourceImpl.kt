package com.videosandbooksapp.data.remotedatalayer

import com.google.gson.Gson
import com.videosandbooksapp.models.Videos
import io.reactivex.Single
import io.reactivex.rxjava3.core.SingleObserver
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val retrofitService: RetrofitService):RemoteDataSource {
    override fun getVideos(): Single<List<Videos>> {
        return retrofitService.getVideos()
    }


}