package com.example.hastravani.view.registration

import androidx.lifecycle.ViewModel
import com.example.hastravani.Remote.UserRepository

class RegistrationViewModel(private val repository: UserRepository): ViewModel() {
    fun registerNew(
        name: String,
        email: String,
        password: String,
        phone: String
    ) =repository.registerHV(name,email,password,phone)
}