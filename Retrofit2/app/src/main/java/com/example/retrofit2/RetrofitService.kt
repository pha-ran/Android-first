package com.example.retrofit2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    // @GET( EndPoint - 자원위치(URI) )
    @GET("posts/{post}")
    fun getPosts(@Path("post") post : String): Call<PostResult>
}