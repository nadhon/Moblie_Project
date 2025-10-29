package com.exemple.myaplication.service
import com.example.myaplication.model.Posts
import retrofite2.http.GET

interface ApiService{

  @GET("posts")
  suspend fun getPosts() : List<posts
}
