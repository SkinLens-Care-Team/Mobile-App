package com.example.skinlenscare.ui.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.skinlenscare.R
import com.example.skinlenscare.adapter.HistoryAdapter
import com.example.skinlenscare.data.History
import com.example.skinlenscare.databinding.FragmentHistoryBinding
import com.example.skinlenscare.DiagnoseActivity

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        val historyList = listOf(
            History(R.drawable.jerawatan, "Acne", "12 December 2024"),
            History(R.drawable.jerawatan2, "Acne", "15 May 2024"),
            History(R.drawable.rosacea2, "Rosacea", "18 May 2024")
        )

        val adapter = HistoryAdapter(historyList) { history ->
            // Navigasi ke DiagnoseActivity dengan data
            val intent = Intent(requireContext(), DiagnoseActivity::class.java).apply {
                putExtra("EXTRA_HISTORY_TITLE", history.title)
                putExtra("EXTRA_HISTORY_DATE", history.tanggal)
            }
            startActivity(intent)
        }

        binding.recyclerViewHistory.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerViewHistory.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
