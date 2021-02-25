package com.example.clone_everytime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment : HomeFragment
    lateinit var tableFragment: TableFragment
    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        tableFragment = TableFragment()
        fragmentChange(homeFragment)

        bottomNavigationView = findViewById(R.id.main_activity_bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_navigation_item_home -> {
                    fragmentChange(homeFragment)
                }
                R.id.bottom_navigation_item_timetable -> {
                    fragmentChange(tableFragment)
                }
            }
            true
        }
    }

    fun fragmentChange(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_framelayout, fragment).commit()
    }

    fun toolBarChange(toolbar : Toolbar?) {
        setSupportActionBar(toolbar)
    }
}