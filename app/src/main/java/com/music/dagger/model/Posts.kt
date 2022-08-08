package com.music.dagger.model

import com.google.gson.Gson

data class Posts(
    val id:Int,
    val userId:Int,
    val title:String,
    val body:String
)

data class Users(
    val id:Int,
    val name:String,
    val username:String
)

data class Albums(
    val id:Int,
    val userId:Int,
    val title:String
)

data class DetailsModel(
    val posts: List<Posts>,
    val users:List<Users>,
    val albums:List<Albums>
){
    fun toJson():String{
        return Gson().toJson(this)
    }
}

