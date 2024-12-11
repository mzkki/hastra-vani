package com.example.hastravani.view.verification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hastravani.Remote.UserRepository
import com.example.hastravani.Remote.Result
import kotlinx.coroutines.launch

class VerificationViewModel (
    private val userRepository: UserRepository
) : ViewModel(){

    private val _verificationResult = MutableLiveData<Result<Boolean>>()
    val verificationResult: LiveData<Result<Boolean>> = _verificationResult

    private val _resendOtpResult = MutableLiveData<Result<Boolean>>()
    val resendOtpResult: LiveData<Result<Boolean>> = _resendOtpResult

    fun verifyOTP(otp: String) {
        _verificationResult.value = Result.Loading
        viewModelScope.launch {
            _verificationResult.value = userRepository.verifyOTP(otp)
        }
    }

    fun resendOTP() {
        _resendOtpResult.value = Result.Loading
        viewModelScope.launch {
            _resendOtpResult.value = userRepository.resendOTP()
        }
    }
}