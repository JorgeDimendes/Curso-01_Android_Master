package com.jordev.appassistirfilmes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jordev.appassistirfilmes.databinding.ActivityMainBinding
import com.jordev.appassistirfilmes.view.FormLogin

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconde Action Bar --> não vai funcionar pois não deixei ativo
        supportActionBar!!.hide()
        // Essa é a cor do status
        window.statusBarColor = Color.parseColor("#000000")

        //Fazer a transição de tela
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
            finish()
        }, 2000)
        // 2000 = 2s

    }
}