package com.example.ex_kakaologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity() {

    lateinit var imageview : ImageView
    lateinit var textview : TextView
    lateinit var login : ImageButton
    lateinit var logout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //키 해시 등록을 위한 로그 출력
        println("${Utility.getKeyHash(this)}")

        imageview = findViewById(R.id.imageview)
        textview = findViewById(R.id.textview)
        login = findViewById(R.id.login)
        logout = findViewById(R.id.logout)

        //로그인 버튼 클릭
        login.setOnClickListener {
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

        //로그아웃 버튼 클릭
        logout.setOnClickListener {
            UserApiClient.instance.logout {
                upDateInfo()
            }
        }

        //실행시 초기화
        upDateInfo()
    }

    fun upDateInfo() {
        //로그인 여부 확인
        UserApiClient.instance.me { user, error ->
            println("user : $user / error : $error")
            //로그인 상태
            if (user != null) {
                //버튼 설정
                login.visibility = View.GONE
                logout.visibility = View.VISIBLE

                //프로필 사진, 닉네임 설정
                Glide.with(this).load(user.kakaoAccount?.profile?.thumbnailImageUrl).circleCrop().into(imageview)
                textview.text = "${user.kakaoAccount?.profile?.nickname}"
            }
            //로그아웃 상태
            else {
                //버튼 설정
                login.visibility = View.VISIBLE
                logout.visibility = View.GONE

                //프로필 사진, 닉네임 설정
                imageview.setImageBitmap(null)
                textview.text = null
            }
        }
    }
}