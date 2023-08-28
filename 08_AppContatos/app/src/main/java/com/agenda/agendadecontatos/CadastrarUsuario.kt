package com.agenda.agendadecontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.agenda.agendadecontatos.dao.UsuarioDao
import com.agenda.agendadecontatos.databinding.ActivityCadastrarUsuarioBinding
import com.agenda.agendadecontatos.model.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CadastrarUsuario : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarUsuarioBinding
    private lateinit var usuarioDao: UsuarioDao
    private val listaUsuarios: MutableList<Usuario> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btCadastrar.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {

                val nome = binding.editNome.text.toString()
                val sobrenome = binding.editSobrenome.text.toString()
                val idade = binding.editIdade.text.toString()
                val celular = binding.editCelular.text.toString()
                val mensagem: Boolean

                if (nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty() || celular.isEmpty()) {
                    mensagem = false
                } else {
                    mensagem = true
                    cadastrar(nome, sobrenome, idade, celular)
                }

                withContext(Dispatchers.Main) {
                    if (mensagem){
                        Toast.makeText(applicationContext, "Sucesso ao cadastrar usuário!", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(applicationContext, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }

    private fun cadastrar(nome: String, sobrenome: String, idade: String, celular: String){
      val usuario = Usuario(nome,sobrenome,idade,celular)
      listaUsuarios.add(usuario)
      usuarioDao = AppDatabase.getInstance(this).usuarioDao()
      usuarioDao.inserir(listaUsuarios)
    }
}