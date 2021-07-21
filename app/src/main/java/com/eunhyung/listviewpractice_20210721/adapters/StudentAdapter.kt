package com.eunhyung.listviewpractice_20210721.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.eunhyung.listviewpractice_20210721.datas.Student
import java.util.*

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {
}