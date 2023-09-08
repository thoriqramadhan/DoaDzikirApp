package com.thoriqramadhan.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thoriqramadhan.doadzikirapp.R
import com.thoriqramadhan.doadzikirapp.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private var _binding:ActivityDetailArticleBinding? = null
    private val binding get() = _binding as ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleArticle = intent.getStringExtra(EXTRA_DATA_TITLE)
        val contnetArticle = intent.getStringExtra(EXTRA_DATA_CONTENT)
        val imgArticle = intent.getIntExtra(EXTRA_DATA_IMAGE,1)

        binding.apply {
            tvDetailTitle.text = "?"
            tvDetailContent.text = "?"
            imgDetailArticle.setImageResource(imgArticle)
        }

    }
//    object used in this activity which can access by other class
    companion object{
        const val EXTRA_DATA_TITLE = "title"
        const val EXTRA_DATA_CONTENT = "content"
        const val EXTRA_DATA_IMAGE = "image"
    }
}