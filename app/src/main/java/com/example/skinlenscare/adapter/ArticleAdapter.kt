package com.example.skinlenscare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skinlenscare.R
import com.example.skinlenscare.data.Article

class ArticleAdapter(
    private val articles: List<Article>,
    private val listener: OnArticleButtonClickListener
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.itemView.findViewById<View>(R.id.articleButton).setOnClickListener {
            listener.onArticleButtonClicked(article)
        }
    }

    override fun getItemCount(): Int = articles.size

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            itemView.findViewById<TextView>(R.id.tv_item_name).text = article.title
            itemView.findViewById<TextView>(R.id.tv_item_date).text = article.date
            itemView.findViewById<TextView>(R.id.tv_description).text = article.description
            itemView.findViewById<ImageView>(R.id.img_item_photo).setImageResource(article.photo)
        }
    }

    // Tambahkan interface di sini
    interface OnArticleButtonClickListener {
        fun onArticleButtonClicked(article: Article)
    }
}
