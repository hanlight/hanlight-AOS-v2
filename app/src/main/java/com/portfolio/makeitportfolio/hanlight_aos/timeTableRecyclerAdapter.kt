package com.portfolio.makeitportfolio.hanlight_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.makeitportfolio.hanlight_aos.Data.timeTable
import kotlinx.android.synthetic.main.timetable_item.view.*

class timeTableRecyclerAdapter(val tiemTableList:ArrayList<timeTable>): RecyclerView.Adapter<timeTableRecyclerAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return tiemTableList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): timeTableRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.timetable_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(tiemTableList[position])
    }
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindItem(timeTable : timeTable){
            itemView.firstSubConst_timetableItem.text = timeTable.firstSub
            itemView.firstNameConst_timetableItem.text = timeTable.firstName

            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"${timeTable.firstName}를 클릭하였습니다.",Toast.LENGTH_SHORT).show()
            }

        }
    }
}