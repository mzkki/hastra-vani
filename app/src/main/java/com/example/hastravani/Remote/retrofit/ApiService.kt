package com.example.hastravani.Remote.retrofit

import com.example.hastravani.Remote.response.LoginResponse
import com.example.hastravani.Remote.response.OTPVerificationRequest
import com.example.hastravani.Remote.response.OTPVerificationResponse
import com.example.hastravani.Remote.response.RegisterResponse
import com.example.hastravani.Remote.response.ResendOTPResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun registerNew(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phone") phone: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun logIn(
        @Field("email") email: String,
        @Field("password") password: String,
    ): LoginResponse

    @POST("verify-otp")
    suspend fun verifyOTP(
        @Body otpRequest: OTPVerificationRequest
    ): OTPVerificationResponse

    @POST("resend-otp")
    suspend fun resendOTP(): ResendOTPResponse
}