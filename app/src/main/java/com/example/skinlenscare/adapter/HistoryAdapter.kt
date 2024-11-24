package com.example.skinlenscare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skinlenscare.R
import com.example.skinlenscare.data.History

class HistoryAdapter(private val historyList: List<History>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    // ViewHolder dengan findViewById
    inner class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPhoto: ImageView = view.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = view.findViewById(R.id.tv_item_name)
        val tvDate: TextView = view.findViewById(R.id.textView5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = historyList[position]
        holder.imgPhoto.setImageResource(history.photo)
        holder.tvTitle.text = "Detection : \n${history.title}"
        holder.tvDate.text = history.tanggal
    }

    override fun getItemCount(): Int = historyList.size
}
