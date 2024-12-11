package com.example.hastravani.data.pref

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean,
    val isVerified: Boolean = false
)