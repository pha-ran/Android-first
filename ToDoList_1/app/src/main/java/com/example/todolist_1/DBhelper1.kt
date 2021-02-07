package com.example.todolist_1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper1(context : Context) : SQLiteOpenHelper(context, "tododb1", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val s = "create table if not exists tododb1 (" +
                "_id integer PRIMARY KEY autoincrement" +
                "title text" +
                "date text" +
                "todo text"

        db?.execSQL(s)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {  }


}