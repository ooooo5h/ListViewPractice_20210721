package com.eunhyung.listviewpractice_20210721

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunhyung.listviewpractice_20210721.adapters.StudentAdapter
import com.eunhyung.listviewpractice_20210721.datas.Student
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

//    학생 목록을 담아둘 ArrayList 변수 추가
    val mStudentList = ArrayList<Student>()

//    xml + 데이터를 조합해서 뿌려주는 Adapter 변수 추가
//    변수는 미리 만들고 싶은데, 대입은 나중에 해야하는 상황
    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        학생 목록을 실제로 추가
        mStudentList.add( Student("전은형" , 1991))
        mStudentList.add( Student("조경진" , 1988))
        mStudentList.add( Student("임슬기" , 1990))
        mStudentList.add( Student("류준열" , 1983))

//        미뤄뒀던 Adapter의 대입을 진행하자
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)


//        완성된 어댑터 변수를 리스트뷰와 연결
        studentListView.adapter = mAdapter

    }
}