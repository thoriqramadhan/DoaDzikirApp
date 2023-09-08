package com.thoriqramadhan.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thoriqramadhan.doadzikirapp.DzikirAdapter
import com.thoriqramadhan.doadzikirapp.R
import com.thoriqramadhan.doadzikirapp.databinding.ActivityDzikirHarianBinding
import com.thoriqramadhan.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.thoriqramadhan.doadzikirapp.model.DataDoaDzikir

class DzikirSetiapSaatActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirSetiapSaatBinding? = null
    private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24)

//        initialize property of _binding with layoutInflater to get the layout
        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
//        replace argument of setContentView using viewBinding
//        this is for connect the view using view binding
        setContentView(binding.root)

//        set recycler view
        val mAdapter = DzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikir())
        binding.rvDzikir.adapter = mAdapter
//        layout managers is a class to set our structure of recyclerView to display dataset
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
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