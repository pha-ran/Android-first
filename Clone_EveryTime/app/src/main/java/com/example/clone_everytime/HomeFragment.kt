package com.example.clone_everytime

import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    var homefragment : View? = null
    var toolbar_home : Toolbar? = null
    lateinit var mainactivity : MainActivity
    var tip_list_item_datalist = ArrayList<tip_list_item_data>()
    var recommended_information_datalist = ArrayList<recommended_information_data>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        homefragment = inflater.inflate(R.layout.fragment_home, container, false)
        toolbar_home = homefragment?.findViewById(R.id.toolbar_home)
        mainactivity = activity as MainActivity
        setHasOptionsMenu(true) //프래그먼트에서 툴바 메뉴를 설정

        setToolBar("에브리타임", "한국항공대")

        //팁 리스트(리사이클러뷰) 설정
        val tip_list_recyclerview = homefragment?.findViewById<RecyclerView>(R.id.tip_list_recyclerview)
        val tip_list_adapter = tip_list_adapter(tip_list_item_datalist, mainactivity)
        val tip_list_layoutmanager = LinearLayoutManager(mainactivity)
        val tip_list_snaphelper = PagerSnapHelper()
        tip_list_layoutmanager.orientation = LinearLayoutManager.HORIZONTAL //가로 방향으로 설정
        tip_list_recyclerview?.layoutManager = tip_list_layoutmanager
        tip_list_recyclerview?.adapter = tip_list_adapter
        tip_list_snaphelper.attachToRecyclerView(tip_list_recyclerview) //PagerSnapHelper 적용
        tip_list_item_datalist.add(tip_list_item_data("오늘의 할일", "2월 18일 (목)"))
        tip_list_item_datalist.add(tip_list_item_data("과목별 담은인원 확인하기", "수강신청 때 뭐가 경쟁률이 높을까?"))
        tip_list_item_datalist.add(tip_list_item_data("원하는 시간의 과목 검색", "월3, 4에 한 개만 더 채우면 딱인데.."))

        //광고 배너(프레임 레이아웃) 설정
        homefragment?.findViewById<FrameLayout>(R.id.home_fragment_ad_framelayout)?.clipToOutline = true //테두리 모양으로 자르기

        //추천 정보(리사이클러뷰) 설정
        val recommended_information_recyclerview = homefragment?.findViewById<RecyclerView>(R.id.recommended_information_recyclerview)
        val recommended_information_adapter = recommended_information_adapter(recommended_information_datalist, mainactivity)
        val recommended_information_layoutmanager = LinearLayoutManager(mainactivity)
        val recommended_information_snaphelper = PagerSnapHelper()
        recommended_information_layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        recommended_information_recyclerview?.layoutManager = recommended_information_layoutmanager
        recommended_information_recyclerview?.adapter = recommended_information_adapter
        recommended_information_snaphelper.attachToRecyclerView(recommended_information_recyclerview)
        recommended_information_datalist.add(recommended_information_data("삼성전자", "AD", "완벽한 새학기를 위한...", "대학생을 위한...", "추천템 보러가기"))
        recommended_information_datalist.add(recommended_information_data("소니 코리아", "AD", "오늘 방송 한마디도...", "나를 위한...", "소니 스토어"))

        return homefragment
    }

    fun setToolBar(title: String, subtitle: String) {
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
