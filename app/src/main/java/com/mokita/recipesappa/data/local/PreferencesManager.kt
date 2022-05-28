package com.mokita.recipesappa.data.local

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(
    private val context: Context
) {
    private val sharedPreference =
        context.getSharedPreferences("Shared Preferences (c) Putin", Context.MODE_PRIVATE)

    var apiKey: String
        get() = sharedPreference.getString("api_key", "03b72ba100fb4d34ac9c3dbbfc1c6437") ?: ""
        set(value) = sharedPreference.edit().putString("api_key", value).apply()
}