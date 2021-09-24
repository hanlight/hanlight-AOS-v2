package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search_password.*
import kotlinx.android.synthetic.main.activity_signup.*

class SearchPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_password)

        backButtonClick()
    }

    private fun backButtonClick(){
        backImg_SearchPassword.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}