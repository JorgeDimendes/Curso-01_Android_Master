package com.jordev.lojavirtual.activities.FormCadastro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.jordev.lojavirtual.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {
    lateinit var binding: ActivityFormCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrar.setOnClickListener {

            val nome = binding.editNome.text.toString()
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){

                val snackbar = Snackbar.make(it, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.setTextColor(Color.WHITE)
                snackbar.show()
            } else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener { tarefa ->
                    if (tarefa.isSuccessful){
                        val snackbar = Snackbar.make(it, "Cadastro realizado com sucesso!", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.setTextColor(Color.WHITE)
                        snackbar.show()
                        //teste zorin
                    }
                }
            }
        }
    }
}