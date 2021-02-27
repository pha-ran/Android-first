package com.example.clone_everytime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.user.UserApiClient

class MyInfoActivity : AppCompatActivity() {

    var toolbar_myinfo : Toolbar? = null
    lateinit var myinfo_info : View
    lateinit var myinfo_thumbnail : ImageView
    lateinit var myinfo_nickname : TextView
    lateinit var myinfo_name : TextView
    lateinit var myinfo_univ : TextView
    lateinit var myinfo_login : Button
    lateinit var myinfo_logout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info)

        myinfo_info = findViewById(R.id.myinfo_info)
        myinfo_thumbnail = findViewById(R.id.myinfo_thumbnail)
        myinfo_nickname = findViewById(R.id.myinfo_nickname)
        myinfo_name = findViewById(R.id.myinfo_name)
        myinfo_univ = findViewById(R.id.myinfo_univ)
        myinfo_login = findViewById(R.id.kakao_login)
        myinfo_logout = findViewById(R.id.kakao_logout)

        //툴바 설정
        toolbar_myinfo = findViewById(R.id.toolbar_myinfo)
        setSupportActionBar(toolbar_myinfo)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //뒤로가기 버튼 설정

        myinfo_login.setOnClickListener {
            //카카오톡 설치 여부 확인
            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                //카카오톡으로 로그인
                LoginClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (token != null) {
                        //로그인 성공
                    }
                    if (error != null) {
                        //로그인 실패
                    }
                    upDateInfo()
                }
            }
            else {
                //카카오계정으로 로그인
                LoginClient.instance.loginWithKakaoAccount(this) { token, error ->
                    if (token != null) {
                        //로그인 성공
                    }
                    if (error != null) {
                        //로그인 실패
                    }
                    upDateInfo()
                }
            }
        }

        myinfo_logout.setOnClickListener {
            UserApiClient.instance.logout {
                upDateInfo()
            }
        }

        upDateInfo()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //뒤로가기 버튼 클릭 시 종료
            android.R.id.home ->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun upDateInfo() {
        //로그인 여부 확인
        UserApiClient.instance.me { user, error ->
            println("user : $user / error : $error")
            //로그인 상태
            if (user != null) {
                myinfo_info.visibility = View.VISIBLE
                myinfo_login.visibility = View.GONE
                myinfo_logout.visibility = View.VISIBLE

                Glide.with(this).load(user.kakaoAccount?.profile?.thumbnailImageUrl).circleCrop().into(myinfo_thumbnail)
                myinfo_nickname.text = "닉네임"
                myinfo_name.text = "${user.kakaoAccount?.profile?.nickname}"
                myinfo_univ.text = "한국항공대"
            }
            //로그아웃 상태
            else {
                myinfo_info.visibility = View.GONE
                myinfo_login.visibility = View.VISIBLE
                myinfo_logout.visibility = View.GONE

                myinfo_thumbnail.setImageBitmap(null)
                myinfo_nickname.text = null
                myinfo_name.text = null
                myinfo_univ.text = null
            }
        }
    }
}