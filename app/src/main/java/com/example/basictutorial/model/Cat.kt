package com.example.basictutorial.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cat (
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("url")
    @Expose
    val url: String
)