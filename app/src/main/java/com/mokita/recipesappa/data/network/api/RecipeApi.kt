package com.mokita.recipesappa.data.network.api

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.Recipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApi {

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("limitLicense")limitLicense: Boolean = true,
        @Query("number")number: Int = 1
    ): Response<RandomRecipe>

}