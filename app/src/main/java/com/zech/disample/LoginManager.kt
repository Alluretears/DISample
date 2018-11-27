package com.zech.disample

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LoginManager @Inject constructor(
    private val apiService: ApiService,
    @Named("app") private val sharedPreferences: SharedPreferences
) {

    fun login(
        userName: String,
        password: String,
        loginCallback: LoginCallback
    ) {
        apiService.login(userName, password, object : LoginCallback {
            override fun onSuccess(token: String) {
                sharedPreferences.edit()
                    .putString("user_token", token)
                    .apply()
                loginCallback.onSuccess(token)
            }

            override fun onFailure(error: String) {
                loginCallback.onFailure(error)
            }

        })
    }
}