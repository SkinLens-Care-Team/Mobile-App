package com.example.skinlenscare

import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
        private const val REQUEST_CODE_CAMERA = 2
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
            openCamera() // Fungsi untuk membuka kamera
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
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_GALLERY)
    }

    // Function to open the camera
    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) // Intent untuk kamera
        startActivityForResult(intent, REQUEST_CODE_CAMERA)
    }

    // Handle the result from gallery or camera
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_GALLERY -> {
                    val selectedImageUri: Uri? = data?.data
                    Toast.makeText(this, "Gambar dipilih: $selectedImageUri", Toast.LENGTH_SHORT).show()
                }
                REQUEST_CODE_CAMERA -> {
                    val photo: Bitmap? = data?.extras?.get("data") as Bitmap? // Mendapatkan bitmap foto
                    Toast.makeText(this, "Foto diambil dengan kamera", Toast.LENGTH_SHORT).show()
                    // Anda dapat memproses bitmap ini (misalnya, menyimpannya atau menampilkan di UI)
                }
            }
        }
    }
}
