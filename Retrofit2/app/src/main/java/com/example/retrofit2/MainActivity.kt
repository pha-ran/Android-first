package com.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BASE_URL_NAVER_API = "https://openapi.naver.com/"
        val CLIENT_ID = "네이버_개발자센터_아이디"
        val CLIENT_SECRET = "네이버_개발자센터_비밀번호"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_NAVER_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(NaverAPI::class.java)
        val callGetSearchNews = api.getSearchNews(CLIENT_ID, CLIENT_SECRET, "테스트")

        // call.enqueue()를 통해 인터페이스로부터 함수를 호출
        // callback을 파라미터로 넣어 통신 성공 및 실패 시의 처리를 핸들링
        // call.execute()함수는 요청을 현재 쓰레드에서 처리하기 때문에 메인 쓰레드에서 사용하면 크래쉬가 발생
        // call.enqueue(callback) 함수를 사용하면 백그라운드 쓰레드에서 요청을 수행한 후에 콜백은 현재 쓰레드에서 처리
        callGetSearchNews.enqueue(object : Callback<ResultGetSearchNews> {
            override fun onResponse(
                call: Call<ResultGetSearchNews>,
                response: Response<ResultGetSearchNews>
            ) {
                Log.d("TAG", "성공 : ${response.raw()}")
            }

            override fun onFailure(call: Call<ResultGetSearchNews>, t: Throwable) {
                Log.d("TAG", "실패 : $t")
            }
        })
    }
}