package com.mokita.recipesappa.data.network.clients

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.data.network.NetworkObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeApiClient {

    suspend fun getRandomRecipe(): ResponseWrapper<RandomRecipe?> {
        return withContext(Dispatchers.IO) {
            val response = NetworkObject.provideRecipesApi().getRandomRecipes()

            when {
                response.isSuccessful -> {
                    ResponseWrapper.Success(response.body())
                }
                else -> {
                    ResponseWrapper.Error(
                        message = response.message(),
                        code = response.code().toShort()
                    )
                }
            }
        }
    }

}