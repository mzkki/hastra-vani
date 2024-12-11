package com.example.hastravani.di

import android.content.Context
import com.example.hastravani.Remote.UserRepository
import com.example.hastravani.Remote.retrofit.ApiConfig
import com.example.hastravani.data.pref.UserPreference
import com.example.hastravani.data.pref.dataStore

object Injection {   fun provideRepository(context: Context): UserRepository {
    val pref = UserPreference.getInstance(context.dataStore)
    val apiService = ApiConfig.getApiService()
    return UserRepository.getInstance(apiService, pref)
}
}