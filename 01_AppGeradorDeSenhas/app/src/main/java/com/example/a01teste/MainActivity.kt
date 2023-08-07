package com.example.a01teste

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a01teste.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val alfabeto = arrayOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGerarSenha.setOnClickListener {
            gerarSenhaAleatoria()
        }
    }

    private fun gerarSenhaAleatoria(){
        val primeiraLetra = (alfabeto.indices).random()
        val segundaLetra = (alfabeto.indices).random()
        val terceiraLetra = (alfabeto.indices).random()

        val letraAleatoria1 = alfabeto[primeiraLetra]
        val letraAleatoria2 = alfabeto[segundaLetra]
        val letraAleatoria3 = alfabeto[terceiraLetra]

        val numeroAleatorios = kotlin.random.Random
        val numeros = numeroAleatorios.nextInt(99999)

        binding.txeSenha.text = "$letraAleatoria1$letraAleatoria2$letraAleatoria3-$numeros"
    }
}