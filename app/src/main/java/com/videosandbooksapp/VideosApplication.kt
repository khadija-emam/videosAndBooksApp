package com.videosandbooksapp

import android.app.Application
import com.videosandbooksapp.di.ApplicationComponent
import com.videosandbooksapp.di.DaggerApplicationComponent


class VideosApplication:Application() {
    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: ApplicationComponent by lazy {
        initializeComponent()
    }

    fun initializeComponent(): ApplicationComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerApplicationComponent.factory().create(this)
    }
}