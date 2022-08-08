package com.music.dagger.di.component

import com.music.dagger.MainActivity
import com.music.dagger.di.module.ActivityModule
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun injectMainActivity(activity: MainActivity)
}