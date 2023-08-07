package co.tiagoaguiar.ganheinamega

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        // Buscar os objetos e ter a referencia deles
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        // Onde começa banco de dados
        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)
        val result = prefs.getString("result", null)

        result?.let{
            txtResult.text = "Ultima aposta:\n $result"
        }
        /*
        Ou
        if(result != null){
            txtResult.text = "Ultima aposta:\n $result"
        }
         */



        btnGenerate.setOnClickListener {

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }

    }


    private fun numberGenerator(text: String, txtResult: TextView) {
        // Aqui é a falha numero 01

        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val qtd = text.toInt() // Converter sting para inteiro

        // Aqui é a falha 2
        if (qtd < 6 || qtd > 15) {
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        // Aqui é sucesso
        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val number = random.nextInt(60) // 0...59
            numbers.add(number + 1)

            if (numbers.size == qtd) {
                break
            }
        }

        txtResult.text = numbers.joinToString(" - ")

        val editor = prefs.edit()
        editor.putString("result", txtResult.text.toString())
        editor.apply()

        // commit -> Salvar de forma sincrona (bloquear a interface)
        //          informar se teve sucesso ou não

        // apply -> Salvar de forma assincrona (não vai bloquear a interface)
        //          não informa se teve sucesso ou não
    }


}