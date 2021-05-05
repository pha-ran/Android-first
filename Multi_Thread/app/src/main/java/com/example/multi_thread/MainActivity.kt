package com.example.multi_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var timerTask : Timer? = null
    private var text2 : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text2 = findViewById(R.id.text2)

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

        findViewById<Button>(R.id.button).setOnClickListener {
            startTimer()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            stopTimer()
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            resetTImer()
        }
    }

    private fun startTimer() {
        timerTask = timer(period = 10) {
            time++

            val sec = time/100
            val milli = time%100

            runOnUiThread {
                text2?.text = "sec = ${sec} : ${milli}"
            }
        }
    }

    private fun stopTimer() {
        timerTask?.cancel()
    }

    private fun resetTImer() {
        timerTask?.cancel()

        time = 0
        text2?.text = "sec = 0 : 0"
    }
}