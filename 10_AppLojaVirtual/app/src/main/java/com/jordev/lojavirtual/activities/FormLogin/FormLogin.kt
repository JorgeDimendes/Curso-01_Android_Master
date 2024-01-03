package com.jordev.lojavirtual.activities.FormLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordev.lojavirtual.R
import com.jordev.lojavirtual.activities.FormCadastro.FormCadastro
import com.jordev.lojavirtual.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {
    lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
            //finish()

            //25/11/2023 16:20
        }
    }
}