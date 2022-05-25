package com.mokita.recipesappa.domain.usecase

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.data.repository.RecipesRepository

class GetRandomRecipeUseCase {
    private val repository by lazy { RecipesRepository() }

    suspend operator fun invoke(): ResponseWrapper<RandomRecipe> {
        return when (val response = repository.getRandomRecipe()) {
            is ResponseWrapper.Success -> {
                if (response.data != null) {
                    ResponseWrapper.Success(response.data)
                } else {
                    throw IllegalArgumentException("Далбаеб")
                }
            }
            is ResponseWrapper.Error -> {
                ResponseWrapper.Error(
                    message = response.message,
                    code = response.code
                )
            }
            else -> ResponseWrapper.Idle
        }
    }
}