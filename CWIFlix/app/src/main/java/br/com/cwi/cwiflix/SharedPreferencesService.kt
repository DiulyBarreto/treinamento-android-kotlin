package br.com.cwi.cwiflix

import android.content.SharedPreferences

object SharedPreferencesService {

    lateinit var sharedPreferences: SharedPreferences

    fun write(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun write(key: String, value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun retrieveString(key: String) = sharedPreferences.getString(key, "")

    fun retrieveFloat(key: String) = sharedPreferences.getFloat(key, -1f)
}