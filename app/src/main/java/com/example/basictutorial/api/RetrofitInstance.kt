package com.example.basictutorial.api
import com.example.basictutorial.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val retrofitCat by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.CAT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

    val catApi :SimpleApi by lazy {
        retrofitCat.create(SimpleApi::class.java)
    }
}