package com.mokita.recipesappa.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(name = "apiKey", value = "03b72ba100fb4d34ac9c3dbbfc1c6437")
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }

}