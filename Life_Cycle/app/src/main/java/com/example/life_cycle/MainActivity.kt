package com.example.life_cycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var pref : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    var id : String? = null
    var pw : String? = null
    lateinit var text1 : TextView
    lateinit var text2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MainActivity2::class.java)
        val button = findViewById<Button>(R.id.button)
        text1 = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)

        pref=getSharedPreferences("login", MODE_PRIVATE)
        editor=pref?.edit()

        button.setOnClickListener {
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        id=pref?.getString("id",null)
        pw=pref?.getString("pw",null)

        if(id!=null && pw!=null){
            text1.text = id
            text2.text = pw
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        editor?.putString("id",id)
        editor?.putString("pw",pw)

        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        editor?.remove("id")?.commit()
        editor?.remove("pw")?.commit()

        super.onDestroy()
    }
}