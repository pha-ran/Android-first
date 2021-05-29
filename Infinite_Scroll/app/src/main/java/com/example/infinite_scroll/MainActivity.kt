package com.example.infinite_scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infinite_scroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.apply {
            binding.recyclerview.layoutManager = LinearLayoutManager(context)
            binding.recyclerview.adapter = Adapter()
        }

        // 스크롤 리스너
        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastPosition = (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val totalCount = recyclerView.adapter!!.itemCount-1

                // 스크롤이 끝에 도달했을 경우
                if (!binding.recyclerview.canScrollVertically(1) && lastPosition == totalCount) {
                    // 프로그래스바 삭제
                    // 다음 데이터 로드
                    // notifyDataSetChanged() -> 전체 목록 새로고침
                    // notifyItemRangeInserted(s, e) -> 인덱스의 범위만큼 새로고침
                }
            }
        })
    }
}
