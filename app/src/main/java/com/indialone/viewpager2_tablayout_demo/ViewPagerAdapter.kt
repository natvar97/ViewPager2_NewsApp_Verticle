package com.indialone.viewpager2_tablayout_demo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.viewpager2_tablayout_demo.model.ArticlesItem

class ViewPagerAdapter(
    private val news: ArrayList<ArticlesItem>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        private val tvAuthor = itemView.findViewById<TextView>(R.id.tv_author)
        private val tvContent = itemView.findViewById<TextView>(R.id.tv_content)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)
        private val tvPublishedAt = itemView.findViewById<TextView>(R.id.tv_published_date)
        private val ivImageNews = itemView.findViewById<ImageView>(R.id.iv_image_news)

        fun bind(article: ArticlesItem) {
            tvTitle.text = article.title
            tvAuthor.text = article.author
            tvContent.text = article.content
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .into(ivImageNews)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind(news[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(news[position].url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }
}