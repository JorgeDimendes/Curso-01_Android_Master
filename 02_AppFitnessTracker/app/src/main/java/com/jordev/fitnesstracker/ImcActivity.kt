package com.jordev.fitnesstracker

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ImcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        // Verifica se a atividade tem uma barra de ação
        val actionBar = supportActionBar
        // Oculta a barra de ação
        actionBar?.hide()

        editWeight = findViewById(R.id.edit_imc_weight)
        editHeight = findViewById(R.id.edit_imc_height)

        val btnSent: Button = findViewById(R.id.btn_imc_send)

        btnSent.setOnClickListener {
            if(!validate()){
                Toast.makeText(this, R.string.fields_message, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val weight = editWeight.text.toString().toInt()
            val height = editHeight.text.toString().toInt()

            val result = calculateIMC(weight, height)
            //Toast.makeText(this, "IMC $result", Toast.LENGTH_LONG).show()

            val imcResponseId = imcResponse(result)
            //Toast.makeText(this, imcResponseId, Toast.LENGTH_LONG).show()

            val dialog = AlertDialog.Builder(this)

            dialog.setTitle("Seu imc é: ")
            dialog.setMessage(R.string.calc)
            dialog.setPositiveButton("texto botao", object : DialogInterface.OnClickListener {

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    
                }

            })

            val d = dialog.create()
            d.show()

        }
    }


    private fun imcResponse(imc: Double): Int{
        //when
        return when{
            imc < 15.0 -> R.string.imc_severely_low_weight
            imc < 16.0 -> R.string.imc_very_low_weight
            imc < 18.5 -> R.string.imc_low_weight
            imc < 25.0 -> R.string.normal
            imc < 30.0 -> R.string.imc_high_weight
            imc < 35.0 -> R.string.imc_so_high_weight
            imc < 40.0 -> R.string.imc_severely_high_weight
            else -> R.string.imc_extreme_weight
        }

        //if else
        /*if (imc < 15.0){
            return R.string.imc_severely_low_weight
        }
        else if(imc < 16.0){
            return R.string.imc_very_low_weight
        } else if(imc < 18.5){
            return R.string.imc_low_weight
        }else if(imc < 25.0){
            return R.string.normal
        }else if(imc < 30.0){
            return R.string.imc_high_weight
        }else if(imc < 35.0){
            return R.string.imc_so_high_weight
        }else if(imc < 40.0){
            return R.string.imc_severely_high_weight
        } else{
            return R.string.imc_extreme_weight
        }*/
    }


    private fun calculateIMC(weight: Int, height: Int): Double{
        // Peso / (altura * altura)

        return weight / ((height / 100.0) * (height / 100.0))
    }

    private fun validate(): Boolean{
        // Não pode inserir valores nulos / vazio
        // Não pode inserir/começar com 0

        // TODO: Opção 01 - Usar if e else
        /*if (editWeight.text.toString().isNotEmpty()
            && editHeight.text.toString().isNotEmpty()
            && !editWeight.text.toString().startsWith("0")
            && !editHeight.text.toString().startsWith("0")){

            //Toast.makeText(this, "Seja bem vindo", Toast.LENGTH_LONG).show()
            return true
        } else {
            //Toast.makeText(this, "Digite seu peso e sua altura", Toast.LENGTH_LONG).show()
            return false
        }*/

        // TODO: Opção 02 - Usar apenas return para simular o if/else
        /*if (editWeight.text.toString().isNotEmpty()
            && editHeight.text.toString().isNotEmpty()
            && !editWeight.text.toString().startsWith("0")
            && !editHeight.text.toString().startsWith("0")){

            //Toast.makeText(this, "Seja bem vindo", Toast.LENGTH_LONG).show()
            return true
        }
            return false*/

        // TODO: Opção 03 - Usar direto o que for verdadeiro
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0"))

    }

}