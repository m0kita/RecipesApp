package com.mokita.recipesappa.data.repository

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.data.network.clients.RecipeApiClient

class RecipesRepository {
    private val apiClient by lazy { RecipeApiClient() }

    suspend fun getRandomRecipe(): ResponseWrapper<RandomRecipe?> = apiClient.getRandomRecipe()
}