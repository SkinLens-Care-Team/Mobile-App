package com.example.skinlenscare.ui.konsultasi
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skinlenscare.R
import com.example.skinlenscare.adapter.KonsultasiAdapter
import com.example.skinlenscare.data.Doctor
import com.example.skinlenscare.databinding.FragmentKonsultasiBinding


class KonsultasiFragment : Fragment() {

    private var _binding: FragmentKonsultasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKonsultasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Daftar dokter
        val doctorList = listOf(
            Doctor("dr. Yoshua Felix", "Rs. Dermato Care Makassar", R.drawable.skin_lens_banner, "628123456789"),
            Doctor("dr. Clara Anastasya", "Rs. Medika Sehat", R.drawable.skin_lens_banner, "628987654321")
        )

        // Set RecyclerView
        val adapter = KonsultasiAdapter(doctorList)
        binding.rvKonsultasi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKonsultasi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
