package com.example.skinlenscare.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinlenscare.R
import com.example.skinlenscare.adapter.ArticleAdapter
import com.example.skinlenscare.data.Article
import com.example.skinlenscare.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        // Dummy data
        val articles = listOf(
            Article(R.drawable.skin_lens_banner, "Kenali Gejala Awal Carcinoma", "12 September 2023"),
            Article(R.drawable.skin_lens_banner, "Kenali Gejala Awal Carcinoma", "12 September 2023"),
            Article(R.drawable.skin_lens_banner, "Kenali Gejala Awal Carcinoma", "12 September 2023")
        )

        // Adapter setup
        val adapter = ArticleAdapter(articles)
        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}