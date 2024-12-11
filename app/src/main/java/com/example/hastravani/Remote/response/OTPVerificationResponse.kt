package com.example.hastravani.Remote.response

data class OTPVerificationRequest(val otp: String)
data class OTPVerificationResponse(
    val isSuccess: Boolean,
    val message: String? = null
)
data class ResendOTPResponse(
    val isSuccess: Boolean,
    val message: String? = null
)