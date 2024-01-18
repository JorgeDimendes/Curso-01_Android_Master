package com.jordev.appmeuportifolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordev.appmeuportifolio.databinding.ActivityProjetosBinding

class ProjetosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjetosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProjetosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toobarProjetos.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}