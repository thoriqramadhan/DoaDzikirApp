package com.thoriqramadhan.doadzikirapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thoriqramadhan.doadzikirapp.model.DoaDzikirItem

class DzikirAdapter : RecyclerView.Adapter<DzikirAdapter.DzikirViewHolder>(){
    private val listData = ArrayList<DoaDzikirItem>()
    fun setData(list: List<DoaDzikirItem>){
        listData.clear()
        listData.addAll(list)
    }
//    Viewholder take responsbility for initialize item view from layout
//    in this class we will describe our item view from layout
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemTitle = view.findViewById<TextView>(R.id.item_title)
        val itemArabic = view.findViewById<TextView>(R.id.item_arabic)
        val itemTranslate = view.findViewById<TextView>(R.id.item_translate)
    }

//provides layout to be used by viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder (
//        class to inflate a layout / view
        LayoutInflater.from(parent.context).inflate(R.layout.item_doa, parent,false)
    )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        val data = listData[position]
        holder.apply {
            itemTitle.text = data.title
            itemArabic.text = data.title
            itemTranslate.text = data.translate
        }
    }
}