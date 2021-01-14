package com.example.basictutorial.api

import retrofit2.http.GET

interface CatApi {

    @GET("")
    suspend fun getCatObj()
}