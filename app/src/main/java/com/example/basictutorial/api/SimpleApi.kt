package com.example.basictutorial.api

import com.example.basictutorial.model.Cat
import com.example.basictutorial.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @Headers(
        "x-api-key: 6da86e3a-9451-4644-acbc-7e160d8e82e8"
    )
    @GET("/v1/images/search?limit=10")
    suspend fun getCat():Response<List<Cat>>

}