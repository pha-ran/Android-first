package com.example.todolist_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class AddFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        val rootView1 = inflater.inflate(R.layout.fragment_add, container, false) as ViewGroup

        val title1 = rootView1.findViewById<EditText>(R.id.editText1)
        val date1 = rootView1.findViewById<EditText>(R.id.editText2)
        val todo1 = rootView1.findViewById<EditText>(R.id.editText3)

        val addbtn = rootView1.findViewById<Button>(R.id.addbtn)
        addbtn.setOnClickListener {
            (activity as MainActivity).addDB(title1.text.toString(),date1.text.toString(),todo1.text.toString())
            title1.text = null
            date1.text = null
            todo1.text = null
        }

        return rootView1
    }


}