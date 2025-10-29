package com.example.myapplication.vielmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx
import kotlinx.coroutines.lauch

class PostViewModel(private val repository : PostRepository): ViewModel() {
  private val _post = MutableLiveData<List<Post>>()
  val post : LiveData<List
