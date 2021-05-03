package com.example.life_cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val id = findViewById<EditText>(R.id.editTextID)
        val pw = findViewById<EditText>(R.id.editTextPW)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val pref=this.getSharedPreferences("login", MODE_PRIVATE)
            val editor=pref.edit()

            editor.putString("id",id.text.toString())
            editor.putString("pw",pw.text.toString())
            editor.commit()

            finish()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}