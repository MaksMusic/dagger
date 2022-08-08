package com.music.dagger.mvp

interface BasePresenter {

    interface Presenter<in T>{
        fun attachView(view:T)
        fun subscribe()
        fun unSubscribe()
    }

    interface View{

    }
}