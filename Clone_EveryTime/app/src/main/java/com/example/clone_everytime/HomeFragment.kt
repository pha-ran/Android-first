package com.example.clone_everytime

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    var homefragment : View? = null
    var toolbar_home : Toolbar? = null
    lateinit var mainactivity : MainActivity
    var tip_list_item_datalist = ArrayList<tip_list_item_data>()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        homefragment = inflater.inflate(R.layout.fragment_home, container, false)
        toolbar_home = homefragment?.findViewById(R.id.toolbar_home)
        mainactivity = activity as MainActivity
        setHasOptionsMenu(true) //프래그먼트에서 툴바 메뉴를 설정

        //리사이클러뷰 설정
        val tip_list_recyclerview = homefragment?.findViewById<RecyclerView>(R.id.tip_list_recyclerview)
        val tip_list_adapter = tip_list_adapter(tip_list_item_datalist, mainactivity)
        val layoutmanager = LinearLayoutManager(mainactivity)
        val snaphelper = PagerSnapHelper()
        layoutmanager.orientation = LinearLayoutManager.HORIZONTAL //가로 방향으로 설정
        tip_list_recyclerview?.layoutManager = layoutmanager
        tip_list_recyclerview?.adapter = tip_list_adapter
        snaphelper.attachToRecyclerView(tip_list_recyclerview) //PagerSnapHelper 적용

        tip_list_item_datalist.add(tip_list_item_data("오늘의 할일", "2월 18일 (목)"))
        tip_list_item_datalist.add(tip_list_item_data("과목별 담은인원 확인하기", "수강신청 때 뭐가 경쟁률이 높을까?"))
        tip_list_item_datalist.add(tip_list_item_data("원하는 시간의 과목 검색", "월3, 4에 한 개만 더 채우면 딱인데.."))

        setToolBar("에브리타임","한국항공대")

        return homefragment
    }

    fun setToolBar(title : String, subtitle : String) {
        toolbar_home?.title = title
        toolbar_home?.subtitle = subtitle
        mainactivity.toolBarChange(toolbar_home) //툴바 적용
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_home_menu, menu) //홈에서 사용할 메뉴 설정
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.toolbar_home_search ->
                Toast.makeText(mainactivity, "검색 버튼 클릭", Toast.LENGTH_SHORT).show() //테스트
            R.id.toolbar_home_myprofile ->
                Toast.makeText(mainactivity, "내 프로필 버튼 클릭", Toast.LENGTH_SHORT).show() //테스트
        }
        return super.onOptionsItemSelected(item)
    }
}
