package com.music.dagger.services

import com.music.dagger.model.Albums
import com.music.dagger.model.Posts
import com.music.dagger.model.Users
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

interface ApiServices {

    @GET("posts")
    fun getPosts():Observable<List<Posts>>

    @GET("users")
    fun getUsers():Observable<List<Users>>

    @GET("albums")
    fun getAlbums():Observable<List<Albums>>

    companion object Factory{
        fun create():ApiServices{
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
            return retrofit.create(ApiServices::class.java)
        }
    }
}