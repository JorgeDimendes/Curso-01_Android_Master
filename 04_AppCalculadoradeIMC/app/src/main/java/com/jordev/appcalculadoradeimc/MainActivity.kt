package com.jordev.appcalculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.jordev.appcalculadoradeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bt_calcular = binding.btCalcular
        val mensagem = binding.mensagem

        bt_calcular.setOnClickListener {

            val editPeso = binding.editPeso.text.toString()
            val editAltura = binding.editAltura.text.toString()

            // Validação
            if(editPeso.isEmpty()){
                mensagem.setText("Inferme o seu Peso")
            } else if(editAltura.isEmpty()){
                mensagem.setText("Informe a sua Altura")
            } else{
                calculoDeIMC()
            }

        }

        // Adicionado o icone de limpar no foolbar
        setSupportActionBar(binding.toolbar)

    }

    private fun calculoDeIMC(){

        val pesoID= binding.editPeso.text.toString().toInt()
        val alturaID= binding.editAltura.text.toString().toFloat()
        val resultado = binding.mensagem

        //val pesoID= binding.editPeso
        //val alturaID= binding.editAltura
        //val peso = Integer.parseInt(pesoID.text.toString())
        //val altura = jova.lang.Float.parseFloat(alturaID.text.toString())

        val imc = pesoID / (alturaID * alturaID)

        val Mensagem = when{
            imc < 18.5 -> "Você é uma pluma fitness! \uD83C\uDFCB️\u200D♂️\uD83D\uDCA8 \n(Abaixo do peso)"
            imc >= 18.5 && imc <= 24.9 -> "Você é uma escultura grega! \uD83D\uDCAA\uD83C\uDFDB️ \n(Peso normal)"
            imc >= 25.0 && imc <= 29.9 -> "Você é uma poção mágica! \uD83E\uDDEA\uD83D\uDD2E \n(Sobrepeso)"
            imc >= 30.0 && imc <= 34.9 -> "Você é um guerreiro da pizza! \uD83C\uDF55⚔️ \n(Obesidade grau I)"
            imc >= 35.0 && imc <= 39.9 -> "Você é um viking dos petiscos! \uD83C\uDF57\uD83C\uDF7A \n(Obesidade grau II)"
            imc >= 40.0 -> "Você é um gigante épico da comida! \uD83C\uDF54\uD83C\uDFF0 \n(Obesidade grau III)"
            else -> "Classificação cósmica desconhecida! 🚀🌌"
        }

        //imc.toString()
        resultado.setText("IMC: $imc \n $Mensagem")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.reset -> {
                val limparEditPeso = binding.editPeso.setText("")
                val limparEditAltura = binding.editAltura.setText("")
                val limparMensagem = binding.mensagem.setText("")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}