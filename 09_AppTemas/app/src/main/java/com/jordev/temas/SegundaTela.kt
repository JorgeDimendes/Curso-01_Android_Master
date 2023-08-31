package com.jordev.temas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordev.temas.databinding.ActivitySegundaTelaBinding

class SegundaTela : AppCompatActivity() {

    lateinit var binding: ActivitySegundaTelaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPrimeira.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}