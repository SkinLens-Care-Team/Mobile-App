package com.example.skinlenscare.ui.article

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.skinlenscare.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val title = intent.getStringExtra("ARTICLE_TITLE")
        val description = intent.getStringExtra("ARTICLE_DESCRIPTION")
        val photo = intent.getIntExtra("ARTICLE_IMAGE", R.drawable.skin_lens_banner)
        findViewById<TextView>(R.id.tvArticleTitle).text = title
        findViewById<TextView>(R.id.tvArticleDescription).text = description
        findViewById<ImageView>(R.id.imageArticle).setImageResource(photo)
        val cardView = findViewById<androidx.cardview.widget.CardView>(R.id.cardViewArticle)
        val shapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopLeftCorner(CornerFamily.ROUNDED, 80f)
            .setTopRightCorner(CornerFamily.ROUNDED, 80f)
            .build()
        val backgroundDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            fillColor = getColorStateList(android.R.color.white)
            elevation = 4f
        }
        cardView.background = backgroundDrawable

        val fabBack = findViewById<FloatingActionButton>(R.id.fabBack)
        fabBack.setOnClickListener {
            onBackPressed()
        }
    }
}
