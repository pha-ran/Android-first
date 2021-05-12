package com.example.multi_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var timerTask : Timer? = null
    private var text2 : TextView? = null
    private var gametime = 30
    private var score = 0
    private var b1 : Button? = null
    private var b2 : Button? = null
    private var b3 : Button? = null
    private var gametimetext : TextView? = null
    private var scoretext : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text2 = findViewById(R.id.text2)

        thread(start = true) {
            var i = 0

            while(i < 100) {
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

        gametimetext = findViewById(R.id.gametime)
        scoretext = findViewById(R.id.score)

        findViewById<Button>(R.id.button4).setOnClickListener {
            startGame()
        }

        b1 = findViewById<Button>(R.id.button5)
        b1?.setOnClickListener {
            score += 1
            b1?.visibility = View.INVISIBLE
        }

        b2 = findViewById<Button>(R.id.button6)
        b2?.setOnClickListener {
            score += 1
            b2?.visibility = View.INVISIBLE
        }

        b3 = findViewById<Button>(R.id.button7)
        b3?.setOnClickListener {
            score += 1
            b3?.visibility = View.INVISIBLE
        }
    }

    private fun startTimer() {
        timerTask = timer(period = 10) {    //실행 주기 = 10ms
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

    private fun startGame() {
        score = 0
        gametime = 30
        b1?.visibility = View.INVISIBLE
        b2?.visibility = View.INVISIBLE
        b3?.visibility = View.INVISIBLE

        timer(period = 1000) {
            if (gametime > 0) {
                gametime--

                runOnUiThread {
                    scoretext?.text = score.toString()
                    gametimetext?.text = gametime.toString()

                    b1v()
                    b2v()
                    b3v()
                }
            }
            else {
                b1?.visibility = View.INVISIBLE
                b2?.visibility = View.INVISIBLE
                b3?.visibility = View.INVISIBLE
            }
        }
    }

    private fun b1v() {
        b1?.visibility = View.INVISIBLE
        var random = Random().nextInt(9)+1

        if (random < 4) {
            b1?.visibility = View.VISIBLE
        }
    }

    private fun b2v() {
        b2?.visibility = View.INVISIBLE
        var random = Random().nextInt(9)+1

        if (random < 4) {
            b2?.visibility = View.VISIBLE
        }
    }

    private fun b3v() {
        b3?.visibility = View.INVISIBLE
        var random = Random().nextInt(9)+1

        if (random < 4) {
            b3?.visibility = View.VISIBLE
        }
    }
}