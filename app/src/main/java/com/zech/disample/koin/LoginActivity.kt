package com.zech.disample.koin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.zech.disample.LoginCallback
import com.zech.disample.LoginManager
import com.zech.disample.R
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {

    val loginManager: LoginManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val userName = edit_user_name.text.toString()
            val password = edit_password.text.toString()
            loginManager.login(userName, password, object : LoginCallback {
                override fun onSuccess(token: String) {
                    Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(error: String) {
                    Toast.makeText(this@LoginActivity, "Login Failure error:$error", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }
}