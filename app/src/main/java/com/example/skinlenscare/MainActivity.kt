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
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_konsultasi, R.id.profile_fragment
            )
        )
        navView.itemIconTintList = null
        navView.setupWithNavController(navController)
        binding.fab.setOnClickListener {
            showBottomSheet()
        }
    }
    private fun showBottomSheet() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
        val bottomSheetBinding = BottomSheetLayoutBinding.inflate(layoutInflater)
        dialog.setContentView(bottomSheetBinding.root)
        val cameraLayout: LinearLayout = bottomSheetBinding.layoutCamera
        val galleryLayout: LinearLayout = bottomSheetBinding.layoutGallery
        val cancelButton: View = bottomSheetBinding.cancelButton
        cameraLayout.setOnClickListener {
            dialog.dismiss()
            openCamera()
        }
        galleryLayout.setOnClickListener {
            dialog.dismiss()
            openGallery()
        }
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = android.R.style.Animation_Dialog
        dialog.window?.setGravity(Gravity.BOTTOM)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_GALLERY)
    }


    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) // Intent untuk kamera
        startActivityForResult(intent, REQUEST_CODE_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_GALLERY -> {
                    val selectedImageUri: Uri? = data?.data
                    Toast.makeText(this, "Gambar dipilih: $selectedImageUri", Toast.LENGTH_SHORT).show()
                    // Kirim URI ke AnalyzeActivity
                    val intent = Intent(this, AnalyzeActivity::class.java)
                    intent.putExtra("imageUri", selectedImageUri.toString()) // Mengirim URI gambar
                    startActivity(intent)
                }
                REQUEST_CODE_CAMERA -> {
                    val photo: Bitmap? = data?.extras?.get("data") as Bitmap?
                    Toast.makeText(this, "Foto diambil dengan kamera", Toast.LENGTH_SHORT).show()
                    // Kirim Bitmap ke AnalyzeActivity
                    val intent = Intent(this, AnalyzeActivity::class.java)
                    intent.putExtra("imageBitmap", photo) // Mengirim Bitmap gambar
                    startActivity(intent)
                }
            }
        }
    }

}
