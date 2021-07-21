package com.eunhyung.listviewpractice_20210721.adapters

import android.content.Context
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.eunhyung.listviewpractice_20210721.datas.Student
import java.util.*

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

//    xml을 코틀린 변수로 꺼내오도록 도와주는 클래스(layoutInflater)
    val inflater = LayoutInflater.from(mContext)


}