package com.example.clone_everytime

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

class HomeFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        val homefragment =  inflater.inflate(R.layout.fragment_home, container, false)
        val toolbar_home = homefragment.findViewById(R.id.toolbar_home) as Toolbar?
        val mainactivity = activity as MainActivity

        toolbar_home?.title = "에브리타임"
        toolbar_home?.subtitle = "한국항공대"
        toolbar_home?.setTitleTextColor(Color.RED)
        toolbar_home?.setSubtitleTextColor(Color.WHITE)

        mainactivity.toolBarChange(toolbar_home)

        return homefragment
    }
}
