package com.kys.daggerhiltclean.di

import com.kys.daggerhiltclean.business.data.cache.CacheDataSource
import com.kys.daggerhiltclean.business.data.network.NetworkDataSource
import com.kys.daggerhiltclean.business.interactors.GetResults
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetBlogs(
            cacheDataSource: CacheDataSource,
            networkDataSource: NetworkDataSource

    ): GetResults {
        return GetResults(cacheDataSource, networkDataSource)
    }
}














