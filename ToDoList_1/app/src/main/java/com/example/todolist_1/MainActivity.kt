package com.example.todolist_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var addFragment: AddFragment
    lateinit var listFragment: ListFragment
    var dblist = ArrayList<itemdata1>()
    var lastBackPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment = AddFragment()
        listFragment = ListFragment()

        supportFragmentManager.beginTransaction().replace(R.id.frame, listFragment).commit()

        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottmNavi)
        bottomNavi.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.list_tab -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, listFragment).commit()
                }
                R.id.add_tab -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, addFragment).commit()
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
    }

    fun addDB(t : String, d : String, o : String) {
        dblist.add(itemdata1("$t","$d","$o"))
        showToast("리스트에 추가되었습니다. (제목 : $t)")
    }

    fun changeDB(t : String, d : String, o : String, p : Int) {
        dblist[p] = itemdata1(t, d, o)
    }

    fun removeDB(i : Int) {
        dblist.removeAt(i)
    }

    fun clearDB() {
        dblist.clear()
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastBackPressedTime < 500) {
            finish()
            return
        }
        lastBackPressedTime = System.currentTimeMillis()
        showToast("'뒤로' 버튼을 한번 더 누르면 종료됩니다.")
    }

    fun showToast (s : String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}