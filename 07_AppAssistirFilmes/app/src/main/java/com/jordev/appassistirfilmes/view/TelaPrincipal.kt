package com.jordev.appassistirfilmes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.jordev.appassistirfilmes.R
import com.jordev.appassistirfilmes.adapter.AdapterCategoria
import com.jordev.appassistirfilmes.databinding.ActivityTelaPrincipalBinding
import com.jordev.appassistirfilmes.model.Categoria
import com.jordev.appassistirfilmes.model.Filme

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private lateinit var adapterCategoria: AdapterCategoria
    private val listaCategorias: MutableList<Categoria> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconde Action Bar --> não vai funcionar pois não deixei ativo
        supportActionBar!!.hide()

        val recyclerViewFilmes = binding.recyclerViewFilmes
        recyclerViewFilmes.layoutManager = LinearLayoutManager(this)
        recyclerViewFilmes.setHasFixedSize(true)
        adapterCategoria = AdapterCategoria(this, listaCategorias)
        recyclerViewFilmes.adapter = adapterCategoria
        getCategorias()

        binding.txtSair.setOnClickListener {
            // Deslogar usuario do sistema
            FirebaseAuth.getInstance().signOut()

            // Depois de sair o usuario vai ser levado para tela login
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "Usuario deslogado com sucesso", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCategorias(){
        val categoria01 = Categoria("Categoria 01")
        listaCategorias.add(categoria01)

        val categoria02 = Categoria("Categoria 02")
        listaCategorias.add(categoria02)

        val categoria03 = Categoria("Categoria 03")
        listaCategorias.add(categoria03)

        val categoria04 = Categoria("Categoria 04")
        listaCategorias.add(categoria04)
    }

}