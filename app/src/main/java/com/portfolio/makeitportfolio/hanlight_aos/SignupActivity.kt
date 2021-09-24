package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*

private var key = 0
private var phone = 0

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        changeBackground()
        authButtonClick()
        backButtonClick()
    }

    private fun changeBackground() {
        keyEdt_Signup1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                keyEdt_Signup1.background = getDrawable(R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    keyEdt_Signup1.background = getDrawable(R.drawable.edittext_style)
                    key = 0
                } else {
                    key = 1
                }
                if (key == 1 && phone == 1) {
                    authBtn_Signup1.background = getDrawable(R.drawable.button_success)
                } else {
                    authBtn_Signup1.background = getDrawable(R.drawable.button_style)
                }
            }

        })

        phoneEdt_Signup1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                phoneEdt_Signup1.background = getDrawable(R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    phoneEdt_Signup1.background = getDrawable(R.drawable.edittext_style)
                    phone = 0
                } else {
                    phone = 1
                }
                if (key == 1 && phone == 1) {
                    authBtn_Signup1.background = getDrawable(R.drawable.button_success)
                } else {
                    authBtn_Signup1.background = getDrawable(R.drawable.button_style)
                }
            }

        })
    }

    private fun authButtonClick() {
        authBtn_Signup1.setOnClickListener { //인증 버튼을 눌렀을 때 이벤트 발생
            if (!(keyEdt_Signup1.text.toString()
                    .isNullOrEmpty()) || !(keyEdt_Signup1.text.toString()
                    .isNullOrBlank()) || !(phoneEdt_Signup1.text.toString()
                    .isNullOrBlank()) || !(phoneEdt_Signup1.text.toString().isNullOrBlank())
            ) {
                val key = keyEdt_Signup1.text.toString() //사용자가 적은 ID를 받아옴
                val phone = phoneEdt_Signup1.text.toString() //사용자가 적은 Password를 받아옴
                val intent = Intent(baseContext, SignupActivity2::class.java)
                intent.putExtra("key", key)
                intent.putExtra("phone", phone)
                startActivity(intent)
                finish()

            } else {
                keyEdt_Signup1.background = getDrawable(R.drawable.edittext_error_style)
                phoneEdt_Signup1.background = getDrawable(R.drawable.edittext_error_style)
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