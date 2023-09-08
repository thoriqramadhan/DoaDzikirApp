package com.thoriqramadhan.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thoriqramadhan.doadzikirapp.DzikirAdapter
import com.thoriqramadhan.doadzikirapp.R
import com.thoriqramadhan.doadzikirapp.databinding.ActivityPagiBinding
import com.thoriqramadhan.doadzikirapp.databinding.ActivityPetangBinding
import com.thoriqramadhan.doadzikirapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petang)

        title = "Dzikir Petang"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24)

        _binding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPetang())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

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