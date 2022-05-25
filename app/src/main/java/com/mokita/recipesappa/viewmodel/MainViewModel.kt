package com.mokita.recipesappa.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokita.recipesappa.data.model.RandomRecipe
import com.mokita.recipesappa.data.model.Recipe
import com.mokita.recipesappa.data.model.ResponseWrapper
import com.mokita.recipesappa.domain.usecase.GetRandomRecipeUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel: ViewModel() {
    private val getRandomRecipeUseCase by lazy { GetRandomRecipeUseCase() }

    private val _randomRecipes = MutableStateFlow<ResponseWrapper<RandomRecipe>>(ResponseWrapper.Idle)
    val randomRecipes: StateFlow<ResponseWrapper<RandomRecipe>> = _randomRecipes

    fun getRandomRecipe() {
        viewModelScope.launch {
            _randomRecipes.value = getRandomRecipeUseCase()
        }
    }
}