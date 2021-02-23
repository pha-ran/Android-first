package com.example.ex_kakaologin

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        //5. Kakao SDK 초기화 (네이티브 앱 키)
        KakaoSdk.init(this, "b69cd3c68fe606123282e39e3f41a728")
    }
}