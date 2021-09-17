package com.videosandbooksapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.videosandbooksapp.ui.download.DownloadViewModel
import com.videosandbooksapp.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.drulabs.bankbuddy.di.ViewModelKey

@Module
abstract class FactoryModule {
    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun home(homeVM: HomeViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(DownloadViewModel::class)
    abstract fun downLoad(viewmodel: DownloadViewModel): ViewModel



}