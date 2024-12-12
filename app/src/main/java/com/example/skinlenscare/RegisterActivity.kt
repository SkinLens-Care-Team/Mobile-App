package com.example.skinlenscare

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi tombol dan teks
        val registerButton: Button = findViewById(R.id.button_register)
        val alreadyHaveAccount: TextView = findViewById(R.id.textView12)

        // Aksi ketika tombol Register ditekan
        registerButton.setOnClickListener {
            // Tampilkan toast registrasi berhasil
            Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

            // Pindah ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Aksi ketika "Already have account?" ditekan
        alreadyHaveAccount.setOnClickListener {
            // Pindah ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
