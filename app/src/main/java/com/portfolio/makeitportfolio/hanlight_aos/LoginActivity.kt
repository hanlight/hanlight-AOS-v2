package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.portfolio.makeitportfolio.hanlight_aos.Data.Login
import com.portfolio.makeitportfolio.hanlight_aos.Net.Client
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private var mBackWait: Long = 0
private val collection: Collection = Collection()

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButtonClick()

        searchID_Login.setOnClickListener {
            val intent = Intent(baseContext, SearchIdActivity::class.java)
            startActivity(intent)
            finish()
        }
        searchPassword_Login.setOnClickListener {
            val intent = Intent(baseContext, SearchPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
        signup_Login.setOnClickListener {
            val intent = Intent(baseContext, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        collection.changeBackground(baseContext, idEdt_Login, passwordEdt_Login, loginBtn_Login)

    }

    private fun loginButtonClick() {
        loginBtn_Login.setOnClickListener { //로그인 버튼을 눌렀을 때 이벤트 발생
            if (passwordEdt_Login.text.toString().isNotEmpty() || passwordEdt_Login.text.toString()
                    .isNotBlank()
            ) {
                val id = idEdt_Login.text.toString() //사용자가 적은 ID를 받아옴
                val password = passwordEdt_Login.text.toString() //사용자가 적은 Password를 받아옴
                val call_R: Call<Login> =
                    Client.getClient.login(id, password) //서버로 이 전에 받아온 id와 password를 전송함
                call_R.enqueue(object : Callback<Login> { //userData 형태로 json 수신
                    override fun onFailure(call: Call<Login>, t: Throwable) { //서버가 닫혔을 때
                        Toast.makeText(
                            applicationContext,
                            "네트워크 혹은 서버에 문제가 있습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<Login>, response: Response<Login>
                    ) { //서버 정상 작동
                        if (response.code() == 200) { //id와 password가 같을 때
                            val intent = Intent(baseContext, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else if (response.code() == 412) { //잘못 된 값이 왔을 때
                            Log.i("Log", response.body().toString())
                            passwordErrorTx_Login.visibility = View.VISIBLE
                            passwordErrorTx_Login.text = R.string.loginError.toString()
                            idEdt_Login.background = AppCompatResources.getDrawable(
                                baseContext,
                                R.drawable.edittext_error_style
                            )
                            passwordEdt_Login.background = AppCompatResources.getDrawable(
                                baseContext,
                                R.drawable.edittext_error_style
                            )
                        }
                    }
                })
            } else {
                passwordErrorTx_Login.visibility = View.VISIBLE
                passwordErrorTx_Login.text = "비밀번호를 입력해주세요."
                passwordEdt_Login.background =
                    AppCompatResources.getDrawable(baseContext, R.drawable.edittext_error_style)
            }
        }
    }

    override fun onBackPressed() { //뒤로가기 버튼 누를 시 이벤트 발생
        val toast =
            Toast.makeText(applicationContext, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT)
        if (System.currentTimeMillis() - mBackWait >= 500) { //버튼을 누른지 0.5초 이상 지날 경우
            mBackWait = System.currentTimeMillis()
            toast.show()
        } else {//0.5초 안에 버튼을 2번 누를 경우
            toast.cancel()
            finish() //종료
        }
    }
}