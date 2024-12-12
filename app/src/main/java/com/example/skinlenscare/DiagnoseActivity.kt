package com.example.skinlenscare

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.skinlenscare.databinding.ActivityDiagnoseBinding
import com.google.android.material.tabs.TabLayoutMediator

class DiagnoseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnoseBinding
    private val tabTitles = arrayListOf("Tentang", "Pengobatan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityDiagnoseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terima data dari Intent
        val historyTitle = intent.getStringExtra("EXTRA_HISTORY_TITLE")
        val historyDate = intent.getStringExtra("EXTRA_HISTORY_DATE")

        // Tampilkan data di UI (optional)
        // binding.tvTitle.text = historyTitle
        // binding.tvDate.text = historyDate

        // Setup adapter
        val pagerAdapter = DiagnosePagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        // Hubungkan TabLayout dengan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position] // Set judul sementara (fallback)
        }.attach()

        // Custom tab titles
        for (i in tabTitles.indices) {
            val textView = LayoutInflater.from(this).inflate(R.layout.tab_title, null) as TextView
            textView.text = tabTitles[i] // Set teks tab dari array `tabTitles`
            binding.tabLayout.getTabAt(i)?.customView = textView
        }

        // Tombol kembali
        binding.fabBack.setOnClickListener { finish() }
    }
}
