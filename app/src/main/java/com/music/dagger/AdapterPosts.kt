package com.music.dagger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.music.dagger.databinding.ListItemPostBinding
import com.music.dagger.model.Posts

class AdapterPosts() : RecyclerView.Adapter<AdapterPosts.ViewHolder>() {
    var listPosts: ArrayList<Posts> = arrayListOf()

    fun AddPost(listPost: List<Posts>) {
        listPosts.addAll(listPost)
        notifyDataSetChanged()
    }


    inner class ViewHolder(var binding: ListItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(posts: Posts) {
            binding.body.text = posts.body
            binding.title.text = posts.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listPosts[position])
    }

    override fun getItemCount(): Int {
        return listPosts.size
    }
}