package com.mokita.recipesappa.data.repository

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.data.network.clients.RecipeApiClient
import javax.inject.Inject

class RecipesRepository @Inject constructor(
    private val apiClient: RecipeApiClient
) {

    suspend fun getRandomRecipe(): ResponseWrapper<RandomRecipe?> = apiClient.getRandomRecipe()
}