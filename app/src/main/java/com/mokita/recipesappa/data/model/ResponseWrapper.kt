package com.mokita.recipesappa.data.model

sealed class ResponseWrapper<out T> {
    data class Error<out T>(
        val message: String?,
        val code: Short
    ): ResponseWrapper<T>()

    data class Success<out T>(
        val data: T
    ): ResponseWrapper<T>()

    object Idle: ResponseWrapper<Nothing>()
}