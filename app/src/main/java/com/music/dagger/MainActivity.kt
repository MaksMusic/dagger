package com.music.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.music.dagger.databinding.ActivityMainBinding
import com.music.dagger.di.component.DaggerActivityComponent
import com.music.dagger.di.module.ActivityModule
import com.music.dagger.model.Albums
import com.music.dagger.model.Posts
import com.music.dagger.model.Users
import javax.inject.Inject

class MainActivity : AppCompatActivity(),MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter
     var adapter = AdapterPosts()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter =  adapter
    }

    init {
        injectDependence()
        presenter.attachView(this)
        presenter.subscribe()
        presenter.responseLoadDataPosts()
        presenter.responseDataModel()
    }

    private fun injectDependence(){
        val component = DaggerActivityComponent.builder()
            .activityModule(ActivityModule())
            .build()
        component.injectMainActivity(this)
    }

    override fun loadDataPosts(list: List<Posts>) {
       adapter.AddPost(list)
    }

    override fun noConnect(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun loadDetailsModel(
        listPosts: List<Posts>,
        listUsers: List<Users>,
        listAlbums: List<Albums>
    ) {
        for (i in listPosts){
            Log.d("POSTS", i.title)
        }

        for (i in listUsers){
            Log.d("USERS", i.username)
        }
        for (i in listAlbums){
            Log.d("ALBUMS", i.title)
        }

    }
}