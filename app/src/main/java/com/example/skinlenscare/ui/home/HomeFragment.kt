package com.example.skinlenscare.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinlenscare.R
import com.example.skinlenscare.adapter.ArticleAdapter
import com.example.skinlenscare.data.Article
import com.example.skinlenscare.databinding.FragmentHomeBinding
import com.example.skinlenscare.ui.article.ArticleActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(), ArticleAdapter.OnArticleButtonClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        // Dummy data
        val articles = listOf(
            Article(R.drawable.acne, "Mengenal Milia", "Milia, yang sering disebut bintik susu atau biji minyak, adalah benjolan atau kista kecil berwarna putih yang terbentuk di bawah kulit. Kista kecil ini jinak dan tidak berbahaya, tetapi dapat menjadi masalah kosmetik bagi banyak orang. Tidak seperti jerawat, milia tidak disebabkan oleh pori-pori yang tersumbat atau infeksi bakteri. Sebaliknya, milia terbentuk oleh sel-sel kulit mati dan keratin yang terperangkap di bawah permukaan kulit. Dalam blog ini, Dr. Charu Sharma, Co-Founder dan Direktur Dermatologi di Cureskin menjelaskan sifat milia, perbedaannya dengan jerawat, serta metode pengobatan dan pencegahan milia yang efektif , termasuk penggunaan aplikasi seperti Cureskin untuk pengobatan milia." ,"12 September 2023"),
            Article(R.drawable.rosacea, "Apa Itu Rosacea ?", "Rosacea adalah kondisi kulit kronis yang ditandai dengan kemerahan pada wajah, pembuluh darah yang terlihat, dan sering kali disertai dengan bintik-bintik menyerupai jerawat. Kondisi ini umumnya muncul pada area pipi, hidung, dagu, dan dahi, dan dapat memburuk seiring waktu jika tidak diobati. Rosacea lebih sering dialami oleh individu dengan kulit terang dan biasanya muncul pada usia dewasa. Meskipun penyebab pastinya belum diketahui, faktor pemicu seperti paparan sinar matahari, stres, makanan pedas, dan minuman beralkohol dapat memperburuk gejalanya. Pengelolaan rosacea meliputi perawatan kulit yang lembut, penggunaan obat-obatan topikal atau oral, dan perubahan gaya hidup untuk menghindari pemicunya. Diagnosis dan pengobatan dini sangat penting untuk mencegah perkembangan lebih lanjut dan meningkatkan kualitas hidup penderita." ,"12 September 2023"),
            Article(R.drawable.jerawat, "Cara Merawat Kulit Berjerawat", "Merawat kulit berjerawat memerlukan perhatian khusus untuk mengurangi peradangan dan mencegah munculnya jerawat baru. Langkah pertama yang penting adalah membersihkan wajah dengan lembut menggunakan pembersih yang bebas alkohol dan pewangi, cukup dua kali sehari atau setelah berkeringat, agar kotoran dan minyak tidak menyumbat pori-pori. Gunakan produk perawatan kulit dan makeup yang berlabel non-komedogenik untuk mencegah pori-pori tersumbat. Hindari memencet jerawat karena dapat menyebabkan iritasi, infeksi, atau bekas luka. Obat jerawat dengan kandungan seperti asam salisilat, benzoyl peroxide, atau retinoid juga dapat membantu mengatasi masalah ini, namun penggunaannya perlu disesuaikan dengan petunjuk atau rekomendasi dokter kulit. Selain itu, penting untuk melindungi kulit dari paparan sinar matahari dengan tabir surya yang ringan, tetap terhidrasi, mengonsumsi makanan bergizi, dan mengelola stres melalui aktivitas relaksasi seperti olahraga atau meditasi. Jika jerawat tidak kunjung membaik atau tergolong parah, konsultasikan dengan dokter kulit untuk mendapatkan perawatan lebih lanjut seperti terapi laser atau pengobatan resep. Perawatan yang konsisten dan sabar sangat penting untuk memperoleh hasil yang optimal." ,"12 September 2023"),
            Article(R.drawable.food, "Makanan Berbahaya Untuk Kulit", "Beberapa jenis makanan dapat berdampak buruk pada kesehatan kulit jika dikonsumsi secara berlebihan. Makanan tinggi gula, seperti permen, kue, dan minuman bersoda, dapat memicu lonjakan kadar insulin yang berkontribusi pada peradangan dan produksi minyak berlebih, sehingga memperparah jerawat. Makanan olahan dan cepat saji yang kaya akan lemak jenuh, garam, dan bahan pengawet juga dapat merusak keseimbangan kulit dan meningkatkan risiko peradangan. Produk susu, terutama susu skim, dikaitkan dengan jerawat pada beberapa orang karena kandungan hormon atau protein tertentu yang dapat memengaruhi hormon tubuh. Makanan yang digoreng dan berminyak cenderung meningkatkan produksi sebum, yang dapat menyumbat pori-pori. Selain itu, makanan dengan indeks glikemik tinggi, seperti roti putih, nasi putih, dan keripik, dapat memicu fluktuasi gula darah yang berdampak buruk pada kesehatan kulit. Oleh karena itu, menjaga pola makan seimbang dengan memperbanyak asupan sayur, buah, protein tanpa lemak, dan lemak sehat sangat penting untuk kesehatan kulit yang optimal." ,"12 September 2023"),
            Article(R.drawable.carcinoma, "Kenali Gejala Awal Carcinoma", "Gejala awal karsinoma dapat bervariasi tergantung pada jenisnya, tetapi secara umum, tanda-tanda yang perlu diwaspadai meliputi munculnya benjolan atau area kulit yang tidak biasa. Pada **karsinoma sel basal (basal cell carcinoma)**, gejala sering berupa bintik kecil berwarna merah muda atau benjolan yang mengkilap, terkadang disertai pembuluh darah halus di permukaannya. Gejala lain bisa berupa luka yang tidak kunjung sembuh atau area kulit yang tampak bersisik dan berkerak. Sementara itu, karsinoma sel skuamosa (squamous cell carcinoma) sering ditandai dengan benjolan keras, kasar, atau bersisik yang dapat terasa sakit atau mudah berdarah. Luka atau bercak merah pada kulit yang terus membesar juga bisa menjadi tanda awal. Karsinoma juga dapat berkembang pada kulit yang sering terpapar sinar matahari, seperti wajah, telinga, leher, tangan, atau kaki. Jika Anda mendeteksi perubahan pada kulit seperti luka yang tidak sembuh, perubahan warna kulit, atau benjolan yang tumbuh cepat, sangat penting untuk segera memeriksakannya ke dokter, karena deteksi dini meningkatkan peluang pengobatan yang lebih efektif." ,"12 September 2023")
        )

        // Adapter setup dengan listener
        val adapter = ArticleAdapter(articles, this)
        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onArticleButtonClicked(article: Article) {
        // Intent ke ArticleActivity
        val intent = Intent(requireContext(), ArticleActivity::class.java)
        intent.putExtra("ARTICLE_TITLE", article.title)
        intent.putExtra("ARTICLE_DATE", article.date)
        intent.putExtra("ARTICLE_DESCRIPTION", article.description)
        intent.putExtra("ARTICLE_IMAGE", article.photo)


        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

