package com.eunhyung.listviewpractice_20210721

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        mStudentList.add( Student("전은형" , 1991, "서울시 중랑구"))
        mStudentList.add( Student("조경진" , 1988, "서울시 제기동"))
        mStudentList.add( Student("임슬기" , 1990, "서울시 서대문구"))
        mStudentList.add( Student("류준열" , 1983, "서울시 강동구"))

//        미뤄뒀던 Adapter의 대입을 진행하자
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)


//        완성된 어댑터 변수를 리스트뷰와 연결
        studentListView.adapter = mAdapter


//        학생리스트뷰 클릭 이벤트 구현
        studentListView.setOnItemClickListener { parent, view, position, id ->

//            position : 몇번 줄이 눌렸는지 알려주는 역할

//            클릭된 학생의 이름을 토스트로 출력해보자
            val clickedStudent = mStudentList[position]
            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()

        }


//        리스트뷰 아이템 길게 눌렀을때 별도 처리
        studentListView.setOnItemLongClickListener { parent, view, position, id ->

//            우선 경고(확인)창을 띄우고, 확인이 눌렸을 때 삭제를 하자
            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제")
            alert.setMessage("설명 문구 : 정말 학생을 삭제하시겠어요?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
//                확인버튼이 눌렸을 때 실행해줄 일
//                학생삭제는 이때 진행하겠다
                //            롱클릭된 학생 목록에서 삭제
                mStudentList.removeAt(position)

//            어댑터가 이를 확인(새로고침)하도록 notifyDataSetChanged()
                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)

//            실제 얼럿 띄우기
            alert.show()


            return@setOnItemLongClickListener true
        }


    }
}