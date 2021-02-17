package com.example.clone_everytime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment : HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_framelayout, homeFragment).commit()
    }

    fun toolBarChange(toolbar : Toolbar?) {
        setSupportActionBar(toolbar)
    }
}