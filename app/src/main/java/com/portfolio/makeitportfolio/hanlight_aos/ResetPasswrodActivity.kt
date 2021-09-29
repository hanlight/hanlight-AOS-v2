package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reset_passwrod.*
import kotlinx.android.synthetic.main.activity_signup.*

class ResetPasswrodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_passwrod)

        backButtonClick()
    }

    private fun backButtonClick(){
        backImg_ResetPassword.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}