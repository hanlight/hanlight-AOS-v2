package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.portfolio.makeitportfolio.hanlight_aos.Data.SearchPassword
import com.portfolio.makeitportfolio.hanlight_aos.Net.Client
import kotlinx.android.synthetic.main.activity_search_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val collection: Collection = Collection()


class SearchPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_password)

        collection.changeBackground(
            baseContext,
            idEdt_SearchPassword,
            phoneEdt_SearchPassword,
            authBtn_SearchPassword
        )
        backButtonClick()
        authButtonClick()
    }

    private fun backButtonClick() {
        backImg_SearchPassword.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun authButtonClick() {
        authBtn_SearchPassword.setOnClickListener {
            if (idEdt_SearchPassword.text.toString()
                    .isNotEmpty() || idEdt_SearchPassword.text.toString()
                    .isNotBlank()
            ) {
                val id = idEdt_SearchPassword.text.toString()
                val phone = phoneEdt_SearchPassword.text.toString()
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
                            Log.i("Log", response.body().toString())
                            val call_R: Call<SearchPassword> =
                                Client.getClient.searchPassword(id, phone)
                            call_R.enqueue(object : Callback<SearchPassword> {
                                override fun onFailure(call: Call<SearchPassword>, t: Throwable) {}
                                override fun onResponse(
                                    call: Call<SearchPassword>,
                                    response: Response<SearchPassword>
                                ) { //서버 정상 작동
                                    if (response.code() == 200) {
                                        Log.i("Log", response.body().toString())
                                        val intent =
                                            Intent(baseContext, ResetPasswrodActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    }
                                }
                            })
                        } else if (response.code() == 412) { //잘못 된 값이 왔을 때
                            Log.i("Log", response.body().toString())
                            error2_SearchPassword.visibility = View.VISIBLE
                        }
                    }
                })
            } else if (phoneEdt_SearchPassword.text.toString()
                    .isNotBlank() || phoneEdt_SearchPassword.text.toString()
                    .isNotBlank()
            ) {
                error2_SearchPassword.visibility = View.VISIBLE
                error2_SearchPassword.text = "비밀번호를 입력해주세요."
                phoneEdt_SearchPassword.background =
                    AppCompatResources.getDrawable(baseContext, R.drawable.edittext_error_style)
            } else {
                error_SearchPassword.visibility = View.VISIBLE
                error_SearchPassword.text = "아이디를 입력해주세요."
                idEdt_SearchPassword.background =
                    AppCompatResources.getDrawable(baseContext, R.drawable.edittext_error_style)
            }
        }
    }

}