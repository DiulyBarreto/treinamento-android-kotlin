package br.com.cwi.cwiflix

import android.content.SharedPreferences

object SharedPreferencesService {

    lateinit var sharedPreferences: SharedPreferences

    fun write(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun writeMediaRating(keyMediaId: Int, valueMediaRating: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(keyMediaId.toString(), valueMediaRating)
        editor.apply()
    }

    fun retrieve(key: String) = sharedPreferences.getString(key, "")
}