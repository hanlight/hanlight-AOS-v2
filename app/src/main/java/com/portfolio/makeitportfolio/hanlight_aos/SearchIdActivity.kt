package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search_id.*
import kotlinx.android.synthetic.main.activity_signup.*

class SearchIdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_id)

        backButtonClick()
    }

    private fun backButtonClick(){
        backImg_SearchId.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}