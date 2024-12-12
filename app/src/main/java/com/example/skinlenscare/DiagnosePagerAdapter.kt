package com.example.skinlenscare

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DiagnosePagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2 // Dua tab: Tentang dan Pengobatan

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TentangFragment() // Fragment untuk "Tentang"
            1 -> PengobatanFragment() // Fragment untuk "Pengobatan"
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}

