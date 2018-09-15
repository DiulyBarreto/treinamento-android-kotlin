package br.com.cwi.cwiflix

import android.app.Application

class CWIFlixAppliation : Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = this.getSharedPreferences("CWIFlixApplication", android.content.Context.MODE_PRIVATE)

        SharedPreferencesService.sharedPreferences = sharedPreferences
    }
}