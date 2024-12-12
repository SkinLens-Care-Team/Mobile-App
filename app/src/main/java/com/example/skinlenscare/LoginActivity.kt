package com.example.skinlenscare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi tombol dan teks
        val loginButton: Button = findViewById(R.id.button)
        val dontHaveAccount: TextView = findViewById(R.id.textView12)

        // Aksi ketika tombol Login ditekan
        loginButton.setOnClickListener {
            // Tampilkan toast login berhasil
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

            // Pindah ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Aksi ketika "Don't have account?" ditekan
        dontHaveAccount.setOnClickListener {
            // Pindah ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
