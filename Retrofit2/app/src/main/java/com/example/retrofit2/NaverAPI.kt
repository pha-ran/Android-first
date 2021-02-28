package com.example.retrofit2

import retrofit2.Call
import retrofit2.http.*

// API 인터페이스 생성

interface NaverAPI {
    // GET 방식
    @GET("v1/search/news.json")
    fun getSearchNews(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        // @Query로 함수를 호출할 때 입력
        @Query("query") query: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null // null로 입력 생략 가능 (필수 X)
    ): Call<ResultGetSearchNews>
}