package com.zech.disample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_dagger2.setOnClickListener {
            startActivity(Intent(this, com.zech.disample.dagger2.LoginActivity::class.java))
        }

        text_koin.setOnClickListener {
            startActivity(Intent(this, com.zech.disample.koin.LoginActivity::class.java))
        }
    }
}
