package com.mokita.recipesappa.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mokita.recipesappa.BuildConfig
import com.mokita.recipesappa.data.network.api.RecipesApi
import com.mokita.recipesappa.data.network.interceptor.ApiKeyInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.spoonacular.com/"

object NetworkObject {

    private fun createOkHttpClient() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(ApiKeyInterceptor())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(createOkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create(provideMoshi()).asLenient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    private fun provideMoshi() = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    fun provideRecipesApi(): RecipesApi = provideRetrofit().create(RecipesApi::class.java)
}