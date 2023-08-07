package com.jordev.appbancodev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordev.appbancodev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saldo.setOnClickListener {
            //Intent consegue navegar de uma tela para outra
            val intent = Intent(this, Saldo::class.java)
            startActivity(intent)
            finish()
        }

        binding.faturas.setOnClickListener {
            //Intent consegue navegar de uma tela para outra
            val intent = Intent(this, Faturas::class.java)
            startActivity(intent)
            finish()
        }

        binding.transferencia.setOnClickListener {
            //Intent consegue navegar de uma tela para outra
            val intent = Intent(this, Transferencia::class.java)
            startActivity(intent)
            finish()
        }

        binding.poupanca.setOnClickListener {
            //Intent consegue navegar de uma tela para outra
            val intent = Intent(this, Poupanca::class.java)
            startActivity(intent)
            finish()
        }

    }
}