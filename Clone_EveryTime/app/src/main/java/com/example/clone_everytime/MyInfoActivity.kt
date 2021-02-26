package com.example.clone_everytime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MyInfoActivity : AppCompatActivity() {

    var toolbar_myinfo : Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info)

        toolbar_myinfo = findViewById(R.id.toolbar_myinfo)
        setSupportActionBar(toolbar_myinfo)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //뒤로가기 버튼 클릭 시 종료
            android.R.id.home ->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }
}