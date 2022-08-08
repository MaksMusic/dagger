package com.music.dagger.di.component

import com.music.dagger.App
import com.music.dagger.di.module.ApplicationModule
import dagger.Component
import dagger.Module

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun injectApp(app: App)
}