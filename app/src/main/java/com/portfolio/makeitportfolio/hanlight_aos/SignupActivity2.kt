package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.portfolio.makeitportfolio.hanlight_aos.Net.Client
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var id = 0
private var psw = 0
private var repsw = 0

class SignupActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)

        changeBackground()

        authButtonClick()

        backButtonClick()
    }

    private fun changeBackground() {
        idEdt_Signup2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                idEdt_Signup2.background = getDrawable(R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    idEdt_Signup2.background = getDrawable(R.drawable.edittext_style)
                    id = 0
                } else {
                    id = 1
                }
                if (id == 1 && psw == 1 && repsw == 1) {
                    signupBtn_Signup2.background = getDrawable(R.drawable.button_success)
                } else {
                    signupBtn_Signup2.background = getDrawable(R.drawable.button_style)
                }
            }

        })

        pswEdt_Signup2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                pswEdt_Signup2.background = getDrawable(R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    pswEdt_Signup2.background = getDrawable(R.drawable.edittext_style)
                    psw = 0
                } else {
                    psw = 1
                }
                if (id == 1 && psw == 1 && repsw == 1) {
                    signupBtn_Signup2.background = getDrawable(R.drawable.button_success)
                } else {
                    signupBtn_Signup2.background = getDrawable(R.drawable.button_style)
                }
            }

        })

        rePswEdt_Signup2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                rePswEdt_Signup2.background = getDrawable(R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    rePswEdt_Signup2.background = getDrawable(R.drawable.edittext_style)
                    psw = 0
                } else {
                    psw = 1
                }
                if (id == 1 && psw == 1 && repsw == 1) {
                    signupBtn_Signup2.background = getDrawable(R.drawable.button_success)
                } else {
                    signupBtn_Signup2.background = getDrawable(R.drawable.button_style)
                }
            }

        })
    }

    private fun authButtonClick() {
        signupBtn_Signup2.setOnClickListener {
            val id = idEdt_Signup2.text.toString() //사용자가 적은 ID를 받아옴
            val password = pswEdt_Signup2.text.toString() //사용자가 적은 Password를 받아옴
            val repassword = rePswEdt_Signup2.text.toString()
            val intent = getIntent()
            val key = intent.getStringExtra("key")
            Log.i("asdfasdf", key.toString())
            if (password.equals(repassword)) {
                val call_R: Call<Void> =
                    Client.getClient.register(id, password, key!!) //서버로 이 전에 받아온 id와 password를 전송함
                call_R.enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>, t: Throwable) { //서버가 닫혔을 때
                        Toast.makeText(
                            applicationContext,
                            "네트워크 혹은 서버에 문제가 있습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    override fun onResponse(call: Call<Void>, response: Response<Void>) { //서버 정상 작동
                        if (response.code() == 200) {
                            val intent = Intent(baseContext, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else if (response.code() == 412) {
                            Log.i("Log", response.body().toString())
                            error_Signup2.text = "중복되는 아이디입니다."
                            error_Signup2.visibility = View.VISIBLE
                        }
                    }
                })
            } else {
                error2_Signup2.visibility = View.VISIBLE
            }
        }
    }

    private fun backButtonClick() {
        backImg_Signup2.setOnClickListener {
            val intent = Intent(baseContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}