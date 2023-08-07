package com.jordev.appassistirfilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.jordev.appassistirfilmes.R
import com.jordev.appassistirfilmes.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconde Action Bar --> não vai funcionar pois não deixei ativo
        supportActionBar!!.hide()

        //Deixa o cursor de digitação em um campo para facilitar a vida do usuario
        binding.editEmail.requestFocus()

        binding.btEntrar.setOnClickListener {

            //Validar campos vazios

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                email.isEmpty() -> {
                    binding.containerEmail.helperText = "Preencha o email!"
                    //Trocar a cor da borda na mensagem de erro
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#FF9800")
                }
                senha.isEmpty() -> {
                    binding.containerSenha.helperText = "Preencha a senha!"
                    //binding.containerSenha.boxStrokeColor = Color.parseColor("FF9800")
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#FF9800")
                }
                else -> {
                    autenticacao(email, senha)
                }
            }

        }

        //Evento de clite para reirecionar para FormCadastro
        binding.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }

    private fun autenticacao (email: String, senha: String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->

            if(autenticacao.isSuccessful) {
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                navegarTelaPrincipal()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Erro ao fazer o login do usuario!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null){
            navegarTelaPrincipal()
        }
    }
}