package com.mokita.recipesappa.domain.usecase

import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.data.repository.RecipesRepository
import javax.inject.Inject

class GetRandomRecipeUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
){

    suspend operator fun invoke(): ResponseWrapper<RandomRecipe> {
        return when (val response = recipesRepository.getRandomRecipe()) {
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