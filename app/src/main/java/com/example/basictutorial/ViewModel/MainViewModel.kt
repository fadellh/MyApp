package com.example.basictutorial.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basictutorial.model.Cat
import com.example.basictutorial.model.Post
import com.example.basictutorial.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val catResponse : MutableLiveData<Response<List<Cat>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getCat() {
        viewModelScope.launch {
            val response : Response<List<Cat>> = repository.getCat()
            catResponse.value = response
        }
    }

}