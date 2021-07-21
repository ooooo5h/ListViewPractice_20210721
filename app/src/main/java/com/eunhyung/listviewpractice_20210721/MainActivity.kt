package com.eunhyung.listviewpractice_20210721

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunhyung.listviewpractice_20210721.datas.Student
import java.util.*

class MainActivity : AppCompatActivity() {

//    학생 목록을 담아둘 ArrayList 변수 추가
    val mStudentList = ArrayList<Student>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        학생 목록을 실제로 추가
        mStudentList.add( Student("전은형" , 1991))
        mStudentList.add( Student("조경진" , 1988))
        mStudentList.add( Student("임슬기" , 1990))
        mStudentList.add( Student("류준열" , 1983))

    }
}