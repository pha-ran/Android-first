package com.example.view_binding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.view_binding.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private lateinit var binding : FragmentBlankBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container,false)

        binding.textView.text = "FragmentBlankBinding"

        return binding.root
    }
}