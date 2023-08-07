package com.jordev.appcalculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordev.appcalculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            val num1 = binding.editNota1.text.toString().toInt()
            val num2 = binding.editNota2.text.toString().toInt()
            val num3 = binding.editNota3.text.toString().toInt()
            val num4 = binding.editNota4.text.toString().toInt()
            val faltas = binding.editFaltas.text.toString().toInt()
            val resultado = binding.txtResultado

            val media = (num1 + num2 + num3 + num4) / 4

            if(media >= 6 && faltas <= 20){
                resultado.setText("Aluno foi Aprovado \n Média final: $media")
                resultado.setTextColor(getColor(R.color.green))

            } else if(faltas > 20){
                resultado.setText("Aluno foi repovado por faltas \n Média final: $media")
                resultado.setTextColor(getColor(R.color.red))
            }else{
                resultado.setText("Aluno foi repovado \n Média final: $media")
                resultado.setTextColor(getColor(R.color.red))
            }

        }

    }
}