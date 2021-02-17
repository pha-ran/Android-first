package com.example.clone_everytime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment : HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        fragmentChange(homeFragment)
    }

    fun fragmentChange(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_framelayout, fragment).commit()
    }

    fun toolBarChange(toolbar : Toolbar?) {
        setSupportActionBar(toolbar)
    }
}