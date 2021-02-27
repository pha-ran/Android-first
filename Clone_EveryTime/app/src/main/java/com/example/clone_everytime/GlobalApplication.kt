package com.example.clone_everytime

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "9ba76731e803727a7838290c0cb64a07")
    }
}