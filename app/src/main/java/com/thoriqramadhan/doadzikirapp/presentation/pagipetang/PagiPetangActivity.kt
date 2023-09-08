package com.thoriqramadhan.doadzikirapp.presentation.pagipetang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.thoriqramadhan.doadzikirapp.R
import com.thoriqramadhan.doadzikirapp.databinding.ActivityPagiPetangBinding

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityPagiPetangBinding? = null
    private val binding get() = _binding as ActivityPagiPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24)
        _binding = ActivityPagiPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi);
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang);

        btnPagi.setOnClickListener(this)
        btnPetang.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, PagiActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, PetangActivity::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

}