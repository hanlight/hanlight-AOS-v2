package com.portfolio.makeitportfolio.hanlight_aos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.portfolio.makeitportfolio.hanlight_aos.Data.Login
import com.portfolio.makeitportfolio.hanlight_aos.Net.Client
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButtonClick()
    }

    private fun loginButtonClick() {
        loginBtn_Login.setOnClickListener { //로그인 버튼을 눌렀을 때 이벤트 발생
            val id = loginBtn_Login.text.toString() //사용자가 적은 ID를 받아옴
            val password = loginBtn_Login.text.toString() //사용자가 적은 Password를 받아옴

            val call_R: Call<Login> =
                Client.getClient.login(id, password) //서버로 이 전에 받아온 id와 password를 전송함
            call_R.enqueue(object : Callback<Login> { //userData 형태로 json 수신
                override fun onFailure(call: Call<Login>, t: Throwable) { //서버가 닫혔을 때
                    Toast.makeText(applicationContext, "네트워크 혹은 서버에 문제가 있습니다.", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onResponse(
                    call: Call<Login>,
                    response: Response<Login>
                ) { //서버 정상 작동
                    if (response.code() == 200) { //id와 password가 같을 때
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent) //ListActivity로 이동
                        finish()
                    } else if (response.code() == 412) { //잘못 된 값이 왔을 때
                        Toast.makeText(applicationContext, "아이디 혹은 비밀번호가 다릅니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        }
    }
}