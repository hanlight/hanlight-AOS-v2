package com.portfolio.makeitportfolio.hanlight_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.makeitportfolio.hanlight_aos.Data.notice
import kotlinx.android.synthetic.main.notice_item.view.*

class noticeRecyclerAdapter (val noticeList:ArrayList<notice>): RecyclerView.Adapter<noticeRecyclerAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return noticeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noticeRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notice_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(noticeList[position])
    }
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindItem(notice : notice){
            itemView.titleTv_noticeItem.text = notice.title
            itemView.contentTv_noticeItem.text = notice.content
            itemView.timeTv_noticeItem.text = notice.createAt

            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"${notice.title}를 클릭하였습니다.",Toast.LENGTH_SHORT).show()
            }

        }
    }
}