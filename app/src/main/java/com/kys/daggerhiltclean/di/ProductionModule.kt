package com.kys.daggerhiltclean.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ProductionModule {

    @Singleton
    @Provides
    fun provideString(): String{
        return "This is a PRODUCTION string to test injection"
    }
}















