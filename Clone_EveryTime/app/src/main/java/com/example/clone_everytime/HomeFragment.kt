package com.example.clone_everytime

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.loader.app.LoaderManager
import android.graphics.Color.red as red1

class HomeFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        val homefragment = inflater.inflate(R.layout.fragment_home, container, false)
        val mainactivity = activity as MainActivity
        val toolbar_home = homefragment.findViewById(R.id.toolbar_home) as Toolbar?

        setHasOptionsMenu(true) //프래그먼트에서 메뉴를 설정
        toolbar_home?.title = "에브리타임"
        toolbar_home?.subtitle = "한국항공대"
        mainactivity.toolBarChange(toolbar_home) //툴바 적용

        return homefragment
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_home_menu, menu) //홈에서 사용할 메뉴 설정
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val mainactivity = activity as MainActivity
        when (item.itemId) {
            R.id.toolbar_home_search ->
                Toast.makeText(mainactivity, "검색 버튼 클릭", Toast.LENGTH_SHORT).show() //테스트
            R.id.toolbar_home_myprofile ->
                Toast.makeText(mainactivity, "내 프로필 버튼 클릭", Toast.LENGTH_SHORT).show() //테스트
        }
        return super.onOptionsItemSelected(item)
    }
}
