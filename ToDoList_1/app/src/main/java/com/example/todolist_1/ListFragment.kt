package com.example.todolist_1

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(), OnDbItemClickListener {

    lateinit var adapter1 : Adapter1
    lateinit var mainA : MainActivity

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false) as ViewGroup

        val btn1 = rootView.findViewById<Button>(R.id.clearbtn)
        val btn2 = rootView.findViewById<Button>(R.id.removebtn)

        val recycler = rootView.findViewById<RecyclerView>(R.id.recycler)
        mainA = activity as MainActivity
        adapter1 = Adapter1(mainA.dblist, mainA, this)
        recycler.layoutManager = LinearLayoutManager(mainA)
        recycler.adapter = adapter1

        btn1.setOnClickListener {
            var b1 = AlertDialog.Builder(mainA)
            b1.setTitle("할일 전체 삭제")
            b1.setMessage("전체 삭제 하시겠습니까?")

            b1.setPositiveButton("예") {dialogInterface, i ->
                mainA.clearDB()
                adapter1.notifyDataSetChanged()
            }.setNegativeButton("아니오") {dialogInterface, i ->
                //동작 X
            }.show()
        }

        btn2.setOnClickListener {
            val b2 = AlertDialog.Builder(mainA)
            val dialogView = layoutInflater.inflate(R.layout.dialog_edittext, null)
            val dialogText = dialogView.findViewById<EditText>(R.id.dialog_edit)

            b2.setTitle("할일 삭제")
            b2.setView(dialogView)
                    .setPositiveButton("확인") { dialogInterface, i ->
                        mainA.removeDB(Integer.parseInt(dialogText.text.toString()))
                        adapter1.notifyDataSetChanged()
                    }
                    .setNegativeButton("취소") { dialogInterface, i ->
                        //동작 X
                    }
                    .show()
        }

        return rootView
    }

    override fun onItemClick(datalist1: ArrayList<itemdata1>, p: Int) {
        val changeD = AlertDialog.Builder(mainA)
        val DView = layoutInflater.inflate(R.layout.dialog_3edittext, null)
        val ed_title = DView.findViewById<EditText>(R.id.dialog_title)
        val ed_date = DView.findViewById<EditText>(R.id.dialog_date)
        val ed_todo = DView.findViewById<EditText>(R.id.dialog_todo)

        changeD.setTitle("할일 수정하기")
        ed_title.setText(datalist1[p].title)
        ed_date.setText(datalist1[p].date)
        ed_todo.setText(datalist1[p].todo)

        changeD.setView(DView)
            .setPositiveButton("확인") { dialogInterface, i ->
                mainA.changeDB(ed_title.text.toString(), ed_date.text.toString(), ed_todo.text.toString(), p)
                adapter1.notifyDataSetChanged()
            }
            .setNegativeButton("취소") { dialogInterface, i ->
                //동작 X
            }
            .show()
    }


}