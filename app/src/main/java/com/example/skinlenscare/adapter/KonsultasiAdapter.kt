package com.example.skinlenscare.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skinlenscare.data.Doctor
import com.example.skinlenscare.databinding.ItemRowKonsultasiBinding

class KonsultasiAdapter(
    private val doctorList: List<Doctor>
) : RecyclerView.Adapter<KonsultasiAdapter.DoctorViewHolder>() {

    inner class DoctorViewHolder(private val binding: ItemRowKonsultasiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: Doctor) {
            binding.apply {
                // Set data dokter ke tampilan
                imgItemPhoto.setImageResource(doctor.photo)
                tvItemName.text = doctor.name
                tvItemDescription.text = doctor.description

                // Klik tombol "Message" membuka WhatsApp
                btnMessage.setOnClickListener {
                    val phoneNumber = doctor.phoneNumber // Ambil nomor telepon dokter
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("https://wa.me/$phoneNumber") // Format nomor untuk WA
                    }
                    itemView.context.startActivity(intent) // Jalankan Intent
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val binding = ItemRowKonsultasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(doctorList[position])
    }

    override fun getItemCount() = doctorList.size
}