package com.example.skinlenscare.ui.history

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skinlenscare.R
import com.example.skinlenscare.adapter.HistoryAdapter
import com.example.skinlenscare.data.History

class HistoryFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        // Dummy Data
        val historyList = listOf(
            History(R.drawable.skin_lens_banner, "Milia", "12 - May - 2023"),
            History(R.drawable.skin_lens_banner, "Acne", "15 - May - 2023"),
            History(R.drawable.skin_lens_banner, "Rosacea", "18 - May - 2023")
        )

        // Setup RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_history)
        recyclerView.layoutManager = GridLayoutManager(context, 2) // 2 kolom
        recyclerView.adapter = HistoryAdapter(historyList)

        return view
    }
}
