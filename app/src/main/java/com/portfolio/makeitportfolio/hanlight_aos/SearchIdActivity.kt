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
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_search_id.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchIdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_id)
        changeBackground()
        backButtonClick()
        authButtonClick()
    }

    private fun backButtonClick() {
        backImg_SearchId.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun changeBackground() {
        phoneEdt_SearchId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                phoneEdt_SearchId.background = getDrawable(R.drawable.edittext_success_style)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank() || s.isNullOrEmpty()) {
                    phoneEdt_SearchId.background = getDrawable(R.drawable.edittext_style)
                    authBtn_SearchId.background = getDrawable(R.drawable.button_style)
                } else {
                    authBtn_SearchId.background = getDrawable(R.drawable.button_success)
                }
            }

        })
    }

    private fun authButtonClick() {
        authBtn_SearchId.setOnClickListener {
            if (!(phoneEdt_SearchId.text.toString()
                    .isNullOrEmpty()) || !(phoneEdt_SearchId.text.toString().isNullOrBlank())
            ) {
                val phone = phoneEdt_SearchId.text.toString()
                val call_R: Call<String> = Client.getClient.sms(phone)
                call_R.enqueue(object : Callback<String> {
                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Toast.makeText(
                            applicationContext,
                            "네트워크 혹은 서버에 문제가 있습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<String>, response: Response<String>
                    ) { //서버 정상 작동
                        if (response.code() == 200) {
                            val code = response.body()
                            Log.i("Log", response.body().toString())
                            val call_R: Call<Void> = Client.getClient.searchId(code!!)
                            call_R.enqueue(object : Callback<Void> { //userData 형태로 json 수신
                                override fun onFailure(call: Call<Void>, t: Throwable) {}
                                override fun onResponse(
                                    call: Call<Void>,
                                    response: Response<Void>
                                ) { //서버 정상 작동
                                    if (response.code() == 200) { //id와 password가 같을 때
                                        Log.i("Log", response.body().toString())
                                        val intent = Intent(baseContext, MainActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    }
                                }
                            })
                        } else if (response.code() == 412) { //잘못 된 값이 왔을 때
                            Log.i("Log", response.body().toString())
                            error_SearchId.visibility = View.VISIBLE
                            error_SearchId.text = "전화번호가 올바르지 않습니다."
                            phoneEdt_SearchId.background =
                                getDrawable(R.drawable.edittext_error_style)
                        } else {
                            passwordErrorTx_Login.visibility = View.VISIBLE
                            passwordErrorTx_Login.text = "비밀번호를 입력해주세요."
                            passwordEdt_Login.background =
                                getDrawable(R.drawable.edittext_error_style)
                        }
                    }
                })
            } else {
                error_SearchId.visibility = View.VISIBLE
                error_SearchId.text = "비밀번호를 입력해주세요."
                phoneEdt_SearchId.background = getDrawable(R.drawable.edittext_error_style)
            }
        }
    }
}