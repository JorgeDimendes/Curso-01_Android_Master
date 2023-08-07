package com.jordev.appbancodev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordev.appbancodev.databinding.ActivityTransferenciaBinding

class Transferencia : AppCompatActivity() {

    private lateinit var binding: ActivityTransferenciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransferenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconde Barra de navegação
        supportActionBar!!.hide()

        val toolbar = binding.toobarTransferencia
        toolbar.title = "Transferencia"
        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.setTitleMargin(200, 0, 200, 0)
        toolbar.setBackgroundColor(getColor(R.color.ligt_blue))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}