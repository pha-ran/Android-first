package com.example.retrofit2

import com.google.gson.annotations.SerializedName

// REST API 응답데이터 구조
/*
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
*/

// DTO 모델 - PostResult Class 선언
public class PostResult(
    @SerializedName("userId")
    private var userId : Int,

    @SerializedName("id")
    private var id : Int,
    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함

    private var title : String,
    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑시켜줌

    @SerializedName("body")
    private var bodyValue : String,
) {
    // toString()을 Override 해주지 않으면 객체 주소값을 출력함

    override fun toString(): String {
        return "PostResult{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", bodyValue='" + bodyValue + '\'' +
                '}';
    }
}