package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import kotlinx.android.synthetic.main.activity_signup.*

private val collection : Collection = Collection()

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        collection.changeBackground(baseContext, keyEdt_Signup1, phoneEdt_Signup1, authBtn_Signup1)
        authButtonClick()
        backButtonClick()
    }


    private fun authButtonClick() {
        authBtn_Signup1.setOnClickListener { //인증 버튼을 눌렀을 때 이벤트 발생
            if (keyEdt_Signup1.text.toString().isNotEmpty() || keyEdt_Signup1.text.toString().isNotBlank() || phoneEdt_Signup1.text.toString()
                    .isNotBlank() || phoneEdt_Signup1.text.toString().isNotBlank()
            ) {
                val key = keyEdt_Signup1.text.toString() //사용자가 적은 ID를 받아옴
                val intent = Intent(baseContext, SignupActivity2::class.java)
                intent.putExtra("key", key)
                startActivity(intent)

            } else {
                keyEdt_Signup1.background = AppCompatResources.getDrawable(baseContext, R.drawable.edittext_error_style)
                phoneEdt_Signup1.background = AppCompatResources.getDrawable(baseContext, R.drawable.edittext_error_style)
            }
        }
    }

    private fun backButtonClick() {
        backImg_Signup1.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}