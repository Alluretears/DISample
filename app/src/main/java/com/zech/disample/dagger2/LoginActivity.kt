package com.zech.disample.dagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.zech.disample.LoginCallback
import com.zech.disample.LoginManager
import com.zech.disample.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_login.edit_password
import kotlinx.android.synthetic.main.activity_login.edit_user_name
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

  @Inject
  lateinit var loginManager: LoginManager

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
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