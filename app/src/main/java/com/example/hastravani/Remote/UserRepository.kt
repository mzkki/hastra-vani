package com.example.hastravani.Remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.example.hastravani.Remote.response.RegisterResponse
import com.example.hastravani.data.pref.UserPreference
import com.example.hastravani.Remote.retrofit.ApiService
import com.example.hastravani.data.pref.UserModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import androidx.lifecycle.map
import com.example.hastravani.Remote.response.ErrorResponse
import com.example.hastravani.Remote.response.OTPVerificationRequest
import kotlinx.coroutines.flow.first

class UserRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
) {

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun registerHV(
        name: String,
        email: String,
        password: String,
        phone: String
    ): LiveData<Result<RegisterResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.registerNew(name = name, email = email, password = password, phone = phone)
            emit(Result.Success(response))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            val errorMessage = errorBody.message
            emit(Result.Error(errorMessage.toString()))
        }
    }

    fun loginHV(email: String, password: String): LiveData<Result<UserModel>> = liveData {
        emit(Result.Loading)

        try {
            val response = apiService.logIn(email, password).loginResult
            userPreference.saveSession(UserModel(email, response.token, true))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            val errorMessage = errorBody.message
            emit(Result.Error(errorMessage.toString()))
        }
        val data: LiveData<Result<UserModel>> = userPreference.getSession().asLiveData().map {
            Result.Success(it)
        }
        emitSource(data)
    }
    suspend fun verifyOTP(otp: String): Result<Boolean> {
        return try {
            // Sesuaikan dengan endpoint API verifikasi OTP di backend Anda
            val response = apiService.verifyOTP(OTPVerificationRequest(otp))

            // Jika verifikasi berhasil, update status di UserPreference
            if (response.isSuccess) {
                // Misalnya, set status verifikasi di sesi pengguna
                val currentSession = userPreference.getSession().first()
                userPreference.saveSession(currentSession.copy(isVerified = true))
                Result.Success(true)
            } else {
                Result.Error(response.message ?: "OTP Verification Failed")
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            Result.Error(errorBody.message.orEmpty())
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun resendOTP(): Result<Boolean> {
        return try {
            // Sesuaikan dengan endpoint API kirim ulang OTP di backend Anda
            val response = apiService.resendOTP()

            if (response.isSuccess) {
                Result.Success(true)
            } else {
                Result.Error(response.message ?: "Resend OTP Failed")
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            Result.Error(errorBody.message.orEmpty())
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        }
    }

    // Update UserModel untuk mendukung status verifikasi
    fun updateUserModel(
        email: String? = null,
        token: String? = null,
        isLogin: Boolean? = null,
        isVerified: Boolean? = null
    ) = liveData {
        val currentSession = userPreference.getSession().first()
        val updatedSession = currentSession.copy(
            email = email ?: currentSession.email,
            token = token ?: currentSession.token,
            isLogin = isLogin ?: currentSession.isLogin,
            isVerified = isVerified ?: currentSession.isVerified
        )
        userPreference.saveSession(updatedSession)
        emit(Result.Success(updatedSession))
    }
    companion object {
        const val TAG = "StoreRepository"

        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService, userPreference)
            }.also { instance = it }
    }
}
