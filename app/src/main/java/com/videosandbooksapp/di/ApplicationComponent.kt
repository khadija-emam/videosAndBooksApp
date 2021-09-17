package com.videosandbooksapp.di

import android.app.Application
import com.videosandbooksapp.ui.download.DownloadFragment
import com.videosandbooksapp.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph
@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class
    , FactoryModule::class])

interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance application:Application): ApplicationComponent
    }

    fun inject(homeFragment: HomeFragment)
    fun inject(downloadFragment: DownloadFragment)
}