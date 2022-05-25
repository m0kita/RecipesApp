package com.mokita.recipesappa

import android.app.Application
import timber.log.Timber

class RecipeApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}