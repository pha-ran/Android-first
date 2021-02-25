package com.example.clone_everytime

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar

class TableFragment : Fragment() {

    var tablefragment : View? = null
    var toolbar_table : Toolbar? = null
    lateinit var mainactivity : MainActivity

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        tablefragment = inflater.inflate(R.layout.fragment_table, container, false)
        toolbar_table = tablefragment?.findViewById(R.id.toolbar_table)
        mainactivity = activity as MainActivity
        setHasOptionsMenu(true) //프래그먼트에서 툴바 메뉴를 설정
        setToolBar("2021년 1학기", "시간표 1")

        return tablefragment
    }

    fun setToolBar(title: String, subtitle: String) {
        toolbar_table?.title = title
        toolbar_table?.subtitle = subtitle
        mainactivity.toolBarChange(toolbar_table) //툴바 적용
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_table_menu, menu) //홈에서 사용할 메뉴 설정
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolbar_table_option ->
                Toast.makeText(mainactivity, "테이블 설정 버튼 클릭", Toast.LENGTH_SHORT).show() //테스트
        }
        return super.onOptionsItemSelected(item)
    }
}