package com.jordev.appmeuportifolio

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.jordev.appmeuportifolio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Deixando foto Redonda
        val fotoPerfil = BitmapFactory.decodeResource(resources, R.drawable.foto_perfil)

        // Transformando foto quadrada em Circulo
        val circulo = RoundedBitmapDrawableFactory.create(resources, fotoPerfil)
        circulo.isCircular = true
        binding.imgFotoPerfil.setImageDrawable(circulo)

        binding.btContato.setOnClickListener {
            navegarContato()
        }

        binding.btProjetos.setOnClickListener {
            navegarProjetos()
        }

    }

    private fun navegarProjetos() {
        val intent = Intent(this, ProjetosActivity::class.java)
        startActivity(intent)
    }

    private fun navegarContato() {
        val intent = Intent(this, ContatoActivity::class.java)
        startActivity(intent)
    }


}