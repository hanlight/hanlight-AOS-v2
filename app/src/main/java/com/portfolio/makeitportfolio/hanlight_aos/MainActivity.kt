package com.portfolio.makeitportfolio.hanlight_aos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.makeitportfolio.hanlight_aos.Data.notice
import com.portfolio.makeitportfolio.hanlight_aos.Data.popContent
import com.portfolio.makeitportfolio.hanlight_aos.Data.timeTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeTable = arrayListOf(
            timeTable("데베", "김유중"),
            timeTable("데베", "김유중"),
            timeTable("웹프", "이중원"),
            timeTable("데베", "김유중"),
            timeTable("데베", "김유중"),
            timeTable("데베", "김유중"),
            timeTable("웹프", "이중원"),
            timeTable("데베", "김유중")
        )

        val notice = arrayListOf(
            notice("한빛 2.0 업데이트 안내", "한빛 업데이트 2.0에대한 업데이트 소식 및 한빛", "1시간 전"),
            notice("한빛 2.0 업데이트 안내", "한빛 업데이트 2.0에대한 업데이트 소식 및 한빛", "1시간 전"),
            notice("한빛 2.0 업데이트 안내", "한빛 업데이트 2.0에대한 업데이트 소식 및 한빛", "1시간 전")
        )

        val popContents = arrayListOf(
            popContent(R.drawable.ex_pic_55, "ㅁㅁㅁ", "2019년 10월 31일 오후 13:01", R.drawable._125, "컴보실 2층에서 시계 잃어버렸어요 보신분??"),
            popContent(R.drawable.ex_pic_55, "ㅁㅁㅁ", "2019년 10월 31일 오후 13:01", R.drawable._126, "컴보실 2층에서 시계 잃어버렸어요 보신분??")
        )


        timeTableRecycler_Main.layoutManager =
            GridLayoutManager(this, 4)
        timeTableRecycler_Main.setHasFixedSize(true)

        noticeRecycle_Main.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        noticeRecycle_Main.setHasFixedSize(true)

        popContentsRecycle_Main.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        popContentsRecycle_Main.setHasFixedSize(true)

        noticeRecycle_Main.adapter = noticeRecyclerAdapter(notice)
        timeTableRecycler_Main.adapter = timeTableRecyclerAdapter(timeTable)
        popContentsRecycle_Main.adapter = popContentsRecyclerAdapter(popContents)
    }
}