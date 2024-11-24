package com.example.skinlenscare

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.skinlenscare.databinding.ActivityMainBinding
import com.example.skinlenscare.databinding.BottomSheetLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val REQUEST_CODE_GALLERY = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.navView

        // Set up navigation
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_konsultasi, R.id.profile_fragment
            )
        )
        navView.itemIconTintList = null
        navView.setupWithNavController(navController)

        // Set up FAB click listener
        binding.fab.setOnClickListener {
            showBottomSheet()
        }
    }

    // Function to show BottomSheetDialog
    private fun showBottomSheet() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
        val bottomSheetBinding = BottomSheetLayoutBinding.inflate(layoutInflater)
        dialog.setContentView(bottomSheetBinding.root)

        val cameraLayout: LinearLayout = bottomSheetBinding.layoutCamera
        val galleryLayout: LinearLayout = bottomSheetBinding.layoutGallery
        val cancelButton: View = bottomSheetBinding.cancelButton

        // Camera option click listener
        cameraLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Pilih Kamera", Toast.LENGTH_SHORT).show()
        }

        // Gallery option click listener
        galleryLayout.setOnClickListener {
            dialog.dismiss()
            openGallery() // Memanggil fungsi untuk membuka galeri
        }

        // Cancel button click listener
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        // Show dialog
        dialog.show()

        // Set layout parameters for BottomSheet
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = android.R.style.Animation_Dialog
        dialog.window?.setGravity(Gravity.BOTTOM)
    }

    // Function to open the gallery
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK) // Intent untuk memilih media
        intent.type = "image/*" // Filter hanya untuk gambar
        startActivityForResult(intent, REQUEST_CODE_GALLERY) // Mulai aktivitas dengan kode permintaan
    }

    // Handle the result from gallery
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            val selectedImageUri: Uri? = data?.data // Mendapatkan URI gambar yang dipilih
            Toast.makeText(this, "Gambar dipilih: $selectedImageUri", Toast.LENGTH_SHORT).show()
            // Anda dapat memproses URI ini (misalnya, menampilkan gambar atau menyimpannya)
        }
    }
}