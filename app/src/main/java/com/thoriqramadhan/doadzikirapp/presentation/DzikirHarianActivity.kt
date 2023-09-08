package com.thoriqramadhan.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thoriqramadhan.doadzikirapp.DzikirAdapter
import com.thoriqramadhan.doadzikirapp.R
import com.thoriqramadhan.doadzikirapp.databinding.ActivityDzikirHarianBinding
import com.thoriqramadhan.doadzikirapp.databinding.ActivityQauliyahShalatBinding
import com.thoriqramadhan.doadzikirapp.model.DataDoaDzikir
import com.thoriqramadhan.doadzikirapp.model.DoaDzikirItem

class DzikirHarianActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirHarianBinding? = null
    private val binding get() = _binding as ActivityDzikirHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24)

//        initialize property of _binding with layoutInflater to get the layout
        _binding = ActivityDzikirHarianBinding.inflate(layoutInflater)
//        replace argument of setContentView using viewBinding
//        this is for connect the view using view binding
        setContentView(binding.root)

        provideDzikirDatas()
        initView()
    }

    private fun initView() {
        val mAdapter = DzikirAdapter()
        mAdapter.setData(provideDzikirDatas())
        binding.rvDzikirHarian.adapter = mAdapter
        binding.rvDzikirHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun provideDzikirDatas(): ArrayList<DoaDzikirItem> {
//        data set of dzikir harian is located in string.xml
//        we need to get the string array from string.xml put into a variable
//        resource is a variable from AppCompact which getting access to Resource directory
//        from resource we can call resource directory like drawable, layout , values , string
//
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (i in titleDzikir.indices){
            val data = DoaDzikirItem(
                titleDzikir[i],arabicDzikir[i],translateDzikir[i]
            )
            listData.add(data)
        }
        return listData
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}