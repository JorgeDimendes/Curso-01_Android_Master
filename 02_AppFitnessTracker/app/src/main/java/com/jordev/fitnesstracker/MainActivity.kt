package com.jordev.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var btnImc: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verifica se a atividade tem uma barra de ação
        val actionBar = supportActionBar
        // Oculta a barra de ação
        actionBar?.hide()

       btnImc = findViewById(R.id.btn_imc)
        btnImc.setOnClickListener {
            // Navegar para proxima tela
            val intent = Intent(this, ImcActivity::class.java)
            startActivity(intent)
        }
    }


}