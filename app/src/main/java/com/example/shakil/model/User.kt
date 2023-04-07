package com.example.shakil.model

data class User(
    val userName: String,
    val profileImage: String,
    val fullName: String,
    val password: String = "1234"
)