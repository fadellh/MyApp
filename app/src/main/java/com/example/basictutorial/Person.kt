package com.example.basictutorial

import java.io.Serializable

data class Person (
    val firstName: String,
    val lastName: String,
    val birtDate: String,
    val country: String,
    val role: String
) : Serializable

