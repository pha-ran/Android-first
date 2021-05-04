package com.example.multi_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        thread(start = true) {
            var i = 0

            while(i < 10) {
                runOnUiThread {
                    findViewById<TextView>(R.id.text).text = "카운트 : ${i}"
                }

                i++
                Thread.sleep(1000)
            }
        }
    }
}