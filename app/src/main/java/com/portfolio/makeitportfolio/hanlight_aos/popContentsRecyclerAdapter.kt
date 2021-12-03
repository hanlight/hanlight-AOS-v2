package com.portfolio.makeitportfolio.hanlight_aos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.makeitportfolio.hanlight_aos.Data.popContent
import kotlinx.android.synthetic.main.notice_item.view.*
import kotlinx.android.synthetic.main.popcontents_item.view.*

class popContentsRecyclerAdapter(val contentList: ArrayList<popContent>) :
    RecyclerView.Adapter<popContentsRecyclerAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): popContentsRecyclerAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.popcontents_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(contentList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(popContent: popContent) {
            itemView.profileImage_popcontentsItem.setImageResource(popContent.profilePic)
            itemView.profileName_popcontentsItem.text = popContent.name
            itemView.date_popcontentsItem.text = popContent.date
            itemView.contentsImage_popcontentsItem.setImageResource(popContent.contentsPic)
            itemView.contentsText_popcontentsItem.text = popContent.content

            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "${popContent.name}님을 클릭하였습니다.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

        }
    }

}