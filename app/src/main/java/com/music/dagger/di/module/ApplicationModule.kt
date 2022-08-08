package com.music.dagger.di.module

import android.app.Application
import com.music.dagger.App
import com.music.dagger.di.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private var app: App) {

    @Provides
    @Singleton
    @PerApplication
    fun providerApplication():Application{
        return app
    }
}