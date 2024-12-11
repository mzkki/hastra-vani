package com.example.hastravani.view.login

import androidx.lifecycle.ViewModel
import com.example.hastravani.Remote.UserRepository

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun loginHV(email: String, password: String) = repository.loginHV(email, password)
}