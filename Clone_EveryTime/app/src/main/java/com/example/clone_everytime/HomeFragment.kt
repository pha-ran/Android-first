package com.example.clone_everytime

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    var homefragment : View? = null
    var toolbar_home : Toolbar? = null
    lateinit var mainactivity : MainActivity
    var tip_list_item_datalist = ArrayList<tip_list_item_data>()
    var recommended_information_datalist = ArrayList<recommended_information_data>()
    var popular_posts_datalist = ArrayList<popular_posts_data>()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
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
        //클릭 이벤트 설정
        tip_list_adapter.setTipListItemClickListener(object : tip_list_adapter.OnTipListItemClickListener{
            override fun onTipListItemClick(view: View, position: Int) {
                val item = tip_list_item_datalist[position]
                Toast.makeText(view.context, "클릭 : ${item.title}", Toast.LENGTH_SHORT).show()
            }

        })
        tip_list_item_datalist.add(tip_list_item_data(R.drawable.ic_tip_list_checkbox,"오늘의 할일", "2월 18일 (목)", Color.BLUE, "전체 보기"))
        tip_list_item_datalist.add(tip_list_item_data(R.drawable.ic_tip_list_checkbox,"과목별 담은인원 확인하기", "수강신청 때 뭐가 경쟁률이 높을까?", Color.GREEN, "확인하기"))
        tip_list_item_datalist.add(tip_list_item_data(R.drawable.ic_tip_list_calander,"원하는 시간의 과목 검색", "월3, 4에 한 개만 더 채우면 딱인데..", Color.YELLOW, "확인하기"))

        //광고 배너(프레임 레이아웃) 설정
        homefragment?.findViewById<FrameLayout>(R.id.home_fragment_ad_framelayout)?.clipToOutline = true //테두리 모양으로 자르기

        //실시간 인기 글(리사이클러뷰) 설정
        val popular_posts_recyclerview = homefragment?.findViewById<RecyclerView>(R.id.popular_posts_recyclerview)
        val popular_posts_adapter =  popular_posts_adapter(popular_posts_datalist, mainactivity)
        val popular_posts_layoutmanager = GridLayoutManager(mainactivity,2)
        popular_posts_layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        popular_posts_recyclerview?.layoutManager = popular_posts_layoutmanager
        popular_posts_recyclerview?.adapter = popular_posts_adapter
        popular_posts_datalist.add(popular_posts_data(R.drawable.ic_home_fragment_calender, "익명1", "2021-02-20", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "자유 게시판", 2, 0))
        popular_posts_datalist.add(popular_posts_data(R.drawable.ic_home_fragment_home, "익명2", "2021-02-21", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "비밀 게시판", 0, 2))

        //추천 정보(리사이클러뷰) 설정
        val recommended_information_recyclerview = homefragment?.findViewById<RecyclerView>(R.id.recommended_information_recyclerview)
        val recommended_information_adapter = recommended_information_adapter(recommended_information_datalist, mainactivity)
        val recommended_information_layoutmanager = LinearLayoutManager(mainactivity)
        val recommended_information_snaphelper = PagerSnapHelper()
        recommended_information_layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        recommended_information_recyclerview?.layoutManager = recommended_information_layoutmanager
        recommended_information_recyclerview?.adapter = recommended_information_adapter
        recommended_information_snaphelper.attachToRecyclerView(recommended_information_recyclerview)
        recommended_information_recyclerview?.addItemDecoration(CirclePagerIndicatorDecoration()) //인디케이터 추가
        recommended_information_datalist.add(recommended_information_data(R.drawable.ic_tip_list_checkbox, "삼성전자", "AD", R.drawable.ad_seed_pink, "완벽한 새학기를 위한...", "대학생을 위한...", "추천템 보러가기"))
        recommended_information_datalist.add(recommended_information_data(R.drawable.ic_tip_list_calander, "소니 코리아", "AD", R.drawable.ad_seed_pink, "오늘 방송 한마디도...", "나를 위한...", "소니 스토어"))

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
            R.id.toolbar_home_myinfo -> {
                val intent = Intent(mainactivity, MyInfoActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
