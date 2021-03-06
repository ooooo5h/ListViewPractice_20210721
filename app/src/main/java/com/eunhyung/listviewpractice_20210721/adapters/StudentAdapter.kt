package com.eunhyung.listviewpractice_20210721.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.eunhyung.listviewpractice_20210721.R
import com.eunhyung.listviewpractice_20210721.datas.Student
import java.util.*

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

//    xml을 코틀린 변수로 꺼내오도록 도와주는 클래스(layoutInflater)
    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        기존의 결과를 버리고, 새로운 결과를 직접 만들어서 사용하겠다.
//        position변수 : 지금 그려주려는 위치가 어디인지 알려주는 역할
//        convertView : 재활용할 용소가 있는지? => 만약 있다면 활용, 없다면 새로 그려주자

        var tempRow = convertView

//        재활용할 요소가 없나? 없으면 그려줘야함
        if(tempRow == null) {
//            tempRow내부가 비어있는 상황!! => 채워주자
            tempRow = inflater.inflate(R.layout.student_list_item, null)
        }
        
//        tempRow는 절대 null이 아니니, 무조건 결과로 나가도 된다
        val row = tempRow!!

//        실제 데이터 변수 => mList변수(목록)안에 들어있다.
        val studentData = mList[position]

//        뿌려질 UI 요소를 가져오자 => row변수안에 있는 텍스트뷰등을 꺼내오자.
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)

//        실제 데이터 UI 반영
        nameTxt.text = studentData.name
//        ageTxt.text = "(${studentData.birthYear}세)"

//        출생 년도 => 몇살인지? 나이에 반영하자
//        2021, 1988년생 => 34살
//        2021, 1991년생 => 31살 => 2021 - 출생년도 + 1

        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val koreanAge = currentYear - studentData.birthYear + 1
        ageTxt.text = "(${koreanAge}세)"

        addressTxt.text = studentData.address
        
//        완성된 row가 화면에 뿌려질 결과로 선정
        return row
    }

}