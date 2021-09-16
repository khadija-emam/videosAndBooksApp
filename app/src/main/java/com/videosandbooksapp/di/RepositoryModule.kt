package com.videosandbooksapp.di
import com.videosandbooksapp.data.repository.Repository
import com.videosandbooksapp.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
 abstract class RepositoryModule {
          @Binds
           abstract fun repositoryBind(homeRepositoryImpl: RepositoryImpl): Repository

}