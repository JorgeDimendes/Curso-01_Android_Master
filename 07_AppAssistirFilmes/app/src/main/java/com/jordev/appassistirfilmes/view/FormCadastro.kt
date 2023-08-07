package com.jordev.appassistirfilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.ktx.Firebase
import com.jordev.appassistirfilmes.R
import com.jordev.appassistirfilmes.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esconde Action Bar --> não vai funcionar pois não deixei ativo
        supportActionBar!!.hide()
        // Essa é a cor do status
        window.statusBarColor = Color.parseColor("#FFFFFFFF")

        // Deixar ponteiro no campo email
        binding.editEmail.requestFocus()


        // Verificação de erro
        binding.btVamosLa.setOnClickListener {
            val email = binding.editEmail.text.toString()

            if (!email.isEmpty()){
                binding.containerSenha.visibility = View.VISIBLE
                binding.btVamosLa.visibility = View.GONE
                binding.btContinuar.visibility = View.VISIBLE
                binding.txtTitulo.setText("Um mundo de séries e filmes \n ilimitados esperando por você.")
                binding.txtDescricao.setText("Crie uma conta para saber mais sobre \n o nosso App Jorge Vision")

                //Mudar cor da borda
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")
                // Limpar para não dar erro
                binding.containerEmail.helperText = ""

                //Habilitar o Header
                binding.containerHeader.visibility = View.VISIBLE

            } else{
                binding.containerEmail.helperText = "O email é obrigatório!"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
            }
        }

        binding.btContinuar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if (!email.isEmpty() && !senha.isEmpty()){
                cadastro(email, senha)

            } else if(senha.isEmpty()){
                binding.containerSenha.boxStrokeColor = Color.parseColor("#FF0000")
                binding.containerSenha.helperText = "A senha é obrigatória!"
                //Fazer a cor da borda do email permanessa verde
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")

            } else if(email.isEmpty()){
                binding.containerEmail.helperText = "O email é obrigatório!"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
            }
        }

        binding.txtEntrar.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }

    }

    private fun cadastro(email: String, senha: String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
            if(cadastro.isSuccessful){
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()

                // Se tudo estiver ok, limpar mensagem de erro
                binding.containerEmail.helperText = ""
                binding.containerSenha.helperText = ""
                // Deixar a cor da borda verde se for sucesso o cadastro
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")
                binding.containerSenha.boxStrokeColor = Color.parseColor("#FF018786")
            }

        }.addOnFailureListener {
            val erro = it

            when{
                //Verificar se o usuario digitou uma senha com menos de 6 caracteres
                erro is FirebaseAuthWeakPasswordException -> {
                    binding.containerSenha.helperText = "Digite  uma senha acima de 6 caracteres!"
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#FF0000")
                }
                // Verificar se tem conta duplicada
                erro is FirebaseAuthUserCollisionException -> {
                    binding.containerEmail.helperText = "Essa conta ja foi cadastrada!"
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")

                }
                // Verificar se o cliente está sem internet para cadastrar
                erro is FirebaseNetworkException -> {
                    binding.containerSenha.helperText = "Sem conexão com a internet!"
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
                }
                // Erro inesperado
                else -> {
                    Toast.makeText(this, "Erro ao cadastrar usuario!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

}