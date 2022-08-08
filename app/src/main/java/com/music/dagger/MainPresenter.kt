package com.music.dagger

import com.music.dagger.model.Albums
import com.music.dagger.model.DetailsModel
import com.music.dagger.model.Posts
import com.music.dagger.model.Users
import com.music.dagger.services.ApiServices
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

class MainPresenter : MainContract.Presenter {

    lateinit var view: MainContract.View
    private var subscriptions = CompositeDisposable()
    private var api = ApiServices.create()

    override fun responseLoadDataPosts() {
        val subscribe = api.getPosts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Posts> ->
                view.loadDataPosts(list)
            }, { error ->
                view.noConnect(error.localizedMessage!!)
            })

        subscriptions.add(subscribe)
    }

    override fun responseDataModel() {
        val subscribe = Observable.zip(
            api.getPosts(),
            api.getUsers(),
            api.getAlbums()
        ) { posts, users, albums ->
            createDetailsModel(posts, users, albums)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ model: DetailsModel ->
                view.loadDetailsModel(model.posts, model.users, model.albums)
            }, { error ->
                view.noConnect(error.localizedMessage!!)
            })

        subscriptions.add(subscribe)
    }

    private fun createDetailsModel(
        listPosts: List<Posts>,
        listUsers: List<Users>,
        listAlbums: List<Albums>
    ): DetailsModel {
        return DetailsModel(listPosts.take(20), listUsers.take(20), listAlbums.take(20))
    }

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun subscribe() {}

    override fun unSubscribe() {
        subscriptions.clear()
    }
}