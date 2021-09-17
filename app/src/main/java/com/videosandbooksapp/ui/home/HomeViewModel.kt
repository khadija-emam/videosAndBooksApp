package com.videosandbooksapp.ui.home

import android.database.Observable
import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.videosandbooksapp.data.repository.Repository
import com.videosandbooksapp.models.Videos
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback


class HomeViewModel @Inject constructor(val repository: Repository):ViewModel() {

    private val _videosList = MutableLiveData<List<Videos>>()
    val videosList: LiveData<List<Videos>>
        get() = _videosList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean>
        get() = _progress
    private val _navigate = MutableLiveData<Videos>()
    val navigate: LiveData<Videos>
        get() = _navigate

    private val c=CompositeDisposable()


    fun getPosts() {
           _progress.value=true
           repository.getVideos()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread()).subscribe(object :SingleObserver<List<Videos>>{
              override fun onSubscribe(d: Disposable) {
                  c.addAll(d)

              }

              override fun onSuccess(t: List<Videos>) {
                  _progress.value=false
                  _videosList.value=t

              }

              override fun onError(e: Throwable) {
                  _progress.value=false
                  _errorMessage.value=e.localizedMessage
              }

          })



    }
    fun onItemClicked(videos: Videos) {
        _navigate.value = videos
    }

    override fun onCleared() {
        super.onCleared()
        c.clear()
    }
}