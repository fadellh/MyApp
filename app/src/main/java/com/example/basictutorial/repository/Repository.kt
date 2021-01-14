package com.example.basictutorial.repository

import com.example.basictutorial.api.RetrofitInstance
import com.example.basictutorial.api.SimpleApi
import com.example.basictutorial.model.Cat
import com.example.basictutorial.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost() : Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getCat() : Response<List<Cat>>{
        return RetrofitInstance.catApi.getCat()
    }

}