package com.music.dagger

import android.app.Application
import com.music.dagger.di.component.ApplicationComponent
import com.music.dagger.di.component.DaggerApplicationComponent
import com.music.dagger.di.module.ApplicationModule

class App : Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component.injectApp(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: App private set
    }
}