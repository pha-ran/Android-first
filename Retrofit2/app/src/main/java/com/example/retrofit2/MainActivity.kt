package com.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        val call = service.getPosts("1")

        call.enqueue(object : Callback<PostResult> {
            override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                if (response.isSuccessful) {
                    // 통신 성공
                    val result = response.body()
                    println("onResponse : ${response.body()}")
                } else {
                    // 통신 실패 (응답 코드 3xx, 4xx 등)
                    println("fail")
                }
            }

            override fun onFailure(call: Call<PostResult>, t: Throwable) {
                //통신 실패 (인터넷 끊김, 예외 발생 등)
                println("onFailure : ${t.message}")
            }
        })
    }
}