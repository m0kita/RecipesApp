package com.mokita.recipesappa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.mokita.recipesappa.viewmodel.MainViewModel
import com.mokita.recipesappa.R
import com.mokita.recipesappa.data.model.ResponseWrapper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launchWhenStarted {
            viewModel.randomRecipes.collect{
                when (it) {
                    is ResponseWrapper.Success -> Timber.e("Success")
                    is ResponseWrapper.Error -> Timber.e("Error")
                }
            }
        }
        viewModel.getRandomRecipe()
    }
}