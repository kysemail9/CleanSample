package com.kys.daggerhiltclean.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kys.daggerhiltclean.business.data.network.NetworkDataSource
import com.kys.daggerhiltclean.business.data.network.NetworkDataSourceImpl
import com.kys.daggerhiltclean.framework.datasource.network.ResultRetrofitService
import com.kys.daggerhiltclean.framework.datasource.network.ResultRetrofitServiceImpl
import com.kys.daggerhiltclean.framework.datasource.network.mappers.NetworkMapper
import com.kys.daggerhiltclean.framework.datasource.network.retrofit.ResultRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl("https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): ResultRetrofit {
        return retrofit
                .build()
                .create(ResultRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideBlogRetrofitService(
            blogRetrofit: ResultRetrofit
    ): ResultRetrofitService {
        return ResultRetrofitServiceImpl(blogRetrofit)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
            blogRetrofitService: ResultRetrofitService,
            networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(blogRetrofitService, networkMapper)
    }
}




















