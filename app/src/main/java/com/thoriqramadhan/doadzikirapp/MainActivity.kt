package com.thoriqramadhan.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.thoriqramadhan.doadzikirapp.databinding.ActivityMainBinding
import com.thoriqramadhan.doadzikirapp.model.ArticleItem
import com.thoriqramadhan.doadzikirapp.presentation.DzikirHarianActivity
import com.thoriqramadhan.doadzikirapp.presentation.DzikirSetiapSaatActivity
import com.thoriqramadhan.doadzikirapp.presentation.pagipetang.PagiPetangActivity
import com.thoriqramadhan.doadzikirapp.presentation.QauliyahShalatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()
    private val slidingCallback = object: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Toast.makeText(this@MainActivity,"Page ${position}" , Toast.LENGTH_SHORT).show()
            for (i in initData().indices){
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
                )
            }
            dotSliderIndicator[0]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.active_dot)
            )
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        method ini dari dependencies Splash Screen API 12
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardQauliyahShalat = findViewById<MaterialCardView>(R.id.cv_qauliyah_Shalat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.cv_dzikir);
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.cv_dzikir_harian);
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.cv_pagi_petang);

        cardQauliyahShalat.setOnClickListener{
            val intent = Intent(this, QauliyahShalatActivity::class.java)
            startActivity(intent)
        }

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData())
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)

        setUpViewPager()
    }
    private fun setUpViewPager(){
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices){
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.inactive_dot)
            )
            val params = LinearLayoutCompat.LayoutParams(35,35)
            params.marginEnd = 8
            params.marginStart = 8
            binding.dots.addView(dotSliderIndicator[i],params)

        }
    }
    private fun initData() : List<ArticleItem>{
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        val listData = arrayListOf<ArticleItem>()
        for (i in titleArticle.indices){
            val data = ArticleItem(
                titleArticle[i],
                imgArticle.getResourceId(i,0),
                contentArticle[i]
            )
            listData.add(data)
        }
        imgArticle.recycle()
        return listData
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.cv_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
            R.id.cv_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
            R.id.cv_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))
        }
    }

}
