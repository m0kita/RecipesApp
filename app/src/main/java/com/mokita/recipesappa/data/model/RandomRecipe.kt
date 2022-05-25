package com.mokita.recipesappa.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomRecipe(
    @Json(name = "recipes")
    val recipes: List<Recipe>?
)