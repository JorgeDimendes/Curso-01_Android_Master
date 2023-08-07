package com.jordev.apppreferenciasdousuario

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.jordev.apppreferenciasdousuario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var cor = ""

    companion object {
        //Constantes é recomendado usar MAIUSCOLOS
        const val ARQUIVO_PREFERENCIAS = "ArquivoPreferencias"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tirar barra de ação android
        //supportActionBar!!.hide()


        binding.cor01.setOnClickListener{
            cor = "#147758"
            salvar(cor)
            //setBackgroundResource(R.drawable.bk_05)

        }
        binding.cor02.setOnClickListener{
            cor = "#006666"
            salvar(cor)

        }
        binding.cor03.setOnClickListener{
            cor = "#663399"
            salvar(cor)

        }
        binding.cor04.setOnClickListener{
            cor = "#1E90FF"
            salvar(cor)

        }
        binding.cor05.setOnClickListener{
            cor = "#B33F1B"
            salvar(cor)
        }

    }

    private fun salvar(cor: String){

        binding.lauoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.btTrocarCor.setOnClickListener {view ->

            val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.apply()

            snackbar(view)
        }
    }

    private fun snackbar(view: View){
        val snackbar = Snackbar.make(view,"Cor de fundo alterada com sucesso", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){

        }
        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.WHITE)
        snackbar.setTextColor(Color.BLACK)
        snackbar.show() //executar
    }

    override fun onResume() {
        super.onResume()

        val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")

        //Se a cor não estiver vazia
        if(cor!!.isNotEmpty()){
            binding.lauoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }

}