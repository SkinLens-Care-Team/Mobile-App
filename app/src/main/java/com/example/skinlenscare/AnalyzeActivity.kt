package com.example.skinlenscare

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AnalyzeActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var resultButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyze)

        imageView = findViewById(R.id.imageAnalyze) // Pastikan imageView sudah ada di layout activity_analyze.xml
        resultButton = findViewById(R.id.buttonResult) // Mendapatkan reference dari tombol "Click to see result"

        // Mendapatkan data dari Intent
        val imageUriString = intent.getStringExtra("imageUri")
        val imageBitmap = intent.getParcelableExtra<Bitmap>("imageBitmap")

        // Menampilkan gambar dari URI atau Bitmap
        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            imageView.setImageURI(imageUri) // Menampilkan gambar dari URI
        } else if (imageBitmap != null) {
            imageView.setImageBitmap(imageBitmap) // Menampilkan gambar dari Bitmap
        } else {
            Toast.makeText(this, "Gambar tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        // Menambahkan listener pada tombol Result
        resultButton.setOnClickListener {
            // Arahkan ke DiagnoseActivity
            val intent = Intent(this, DiagnoseActivity::class.java)
            startActivity(intent)
        }
    }
}
