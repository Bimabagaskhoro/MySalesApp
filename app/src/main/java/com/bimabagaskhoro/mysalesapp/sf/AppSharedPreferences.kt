package com.bimabagaskhoro.mysalesapp.sf

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@SuppressLint("CommitPrefEdits")
class AppSharedPreferences @Inject constructor(context: Context) {
    companion object {
        const val PREFS_NAME = "app_pref"
        const val SESSION_LOGIN_KEY = "login_pref"
        const val USER_TOKEN = "user_token"
    }

    val sharedPrefApp = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var loginSession: Boolean
        get() = sharedPrefApp.getBoolean(SESSION_LOGIN_KEY, false)
        set(value) {
            sharedPrefApp.edit()
                .putBoolean(SESSION_LOGIN_KEY, value)
                .apply()
        }

    var userToken: String
        get() = sharedPrefApp.getString(USER_TOKEN, "")!!
        set(value) {
            sharedPrefApp.edit()
                .putString(USER_TOKEN, value)
                .apply()
        }

    var logouts : String
        get() = sharedPrefApp.getString(USER_TOKEN, "")!!
        set(value) {
            sharedPrefApp.edit()
                .clear()
                .apply()
        }
}