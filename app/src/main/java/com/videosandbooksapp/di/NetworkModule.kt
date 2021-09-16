package com.videosandbooksapp.di
import com.videosandbooksapp.data.remotedatalayer.RemoteDataSource
import com.videosandbooksapp.data.remotedatalayer.RemoteDataSourceImpl
import com.videosandbooksapp.data.remotedatalayer.RetrofitService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(includes = [NetworkModule.Binders::class])
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitService(
    ): RetrofitService {

        val client = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RetrofitService::class.java)
    }

    @Module
    interface Binders {
        @Binds
        abstract  fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
    }



}