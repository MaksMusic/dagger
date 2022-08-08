package com.music.dagger.di.module

import com.music.dagger.MainContract
import com.music.dagger.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun providerMainPresenter():MainContract.Presenter{
        return MainPresenter()
    }
}