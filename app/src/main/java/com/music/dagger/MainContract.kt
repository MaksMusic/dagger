package com.music.dagger

import com.music.dagger.model.Albums
import com.music.dagger.model.Posts
import com.music.dagger.model.Users
import com.music.dagger.mvp.BasePresenter

interface MainContract {

    interface View:BasePresenter.View{
        fun loadDataPosts(list: List<Posts>)
        fun noConnect(message:String)

        fun loadDetailsModel(listPosts: List<Posts>, listUsers: List<Users>,listAlbums: List<Albums>)

    }
    interface Presenter:BasePresenter.Presenter<View>{
        fun responseLoadDataPosts()

        fun responseDataModel()
    }
}