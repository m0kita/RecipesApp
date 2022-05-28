package com.mokita.recipesappa.data.network.clients

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.data.network.api.RecipeApi
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RecipeApiClient @Inject constructor(
    private val recipesApi: RecipeApi,
    private val coroutineContext: CoroutineContext
) {

    suspend fun getRandomRecipe(): ResponseWrapper<RandomRecipe?> {
        return withContext(coroutineContext) {
            val response = recipesApi.getRandomRecipes()

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