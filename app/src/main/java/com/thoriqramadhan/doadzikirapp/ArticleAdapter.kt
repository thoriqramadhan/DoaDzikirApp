package com.thoriqramadhan.doadzikirapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thoriqramadhan.doadzikirapp.databinding.ItemArticleBinding
import com.thoriqramadhan.doadzikirapp.model.ArticleItem
import com.thoriqramadhan.doadzikirapp.presentation.DetailArticleActivity

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private var listArticle = ArrayList<ArticleItem>()

    fun setData(list: List<ArticleItem>){
        listArticle.clear()
        listArticle.addAll(list)
    }

    inner class ArticleViewHolder(val view: ItemArticleBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder (
        ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.itemArticle.setImageResource(data.imgArticle)
        holder.itemView.setOnClickListener{
            it.context.apply {
                val intent = Intent(this,DetailArticleActivity::class.java)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_TITLE, data.title)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_CONTENT, data.contentArticle)
                intent.putExtra(DetailArticleActivity.EXTRA_DATA_IMAGE, data.imgArticle)
                startActivity(intent)
            }
        }
    }
}