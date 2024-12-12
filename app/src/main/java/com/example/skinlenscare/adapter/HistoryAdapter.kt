package com.example.skinlenscare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skinlenscare.data.History
import com.example.skinlenscare.databinding.ItemRowHistoryBinding

class HistoryAdapter(
    private val historyList: List<History>,
    private val onItemClick: (History) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(private val binding: ItemRowHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            binding.imgItemPhoto.setImageResource(history.photo)
            binding.tvItemName.text = "Detection : \n${history.title}"
            binding.textView5.text = history.tanggal

            // Set OnClickListener pada item
            binding.root.setOnClickListener { onItemClick(history) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemRowHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = historyList[position]
        holder.bind(history)
    }

    override fun getItemCount(): Int = historyList.size
}
