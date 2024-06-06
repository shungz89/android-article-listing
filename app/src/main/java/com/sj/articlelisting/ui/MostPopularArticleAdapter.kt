package com.sj.articlelisting.ui

// ArticleAdapter.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sj.articlelisting.R
import com.sj.articlelisting.models.Article
import com.sj.articlelisting.models.MostPopularArticle

class MostPopularArticleAdapter(private val articles: List<MostPopularArticle>) :
    RecyclerView.Adapter<MostPopularArticleAdapter.MostPopularArticleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MostPopularArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return MostPopularArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MostPopularArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.articleTitle.text = article.title
        holder.releaseDate.text = article.published_date
    }

    override fun getItemCount(): Int = articles.size

    class MostPopularArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val articleTitle: TextView = itemView.findViewById(R.id.article_title)
        val releaseDate: TextView = itemView.findViewById(R.id.release_date)
    }
}
