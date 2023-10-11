package co.tiagoaguiar.ganheinamega


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var prefes: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recupera a toolbar da atividade
        val actionBar = supportActionBar
        // Oculta a toolbar
        actionBar?.hide()

        // Buscar os objetos e ter a referencia deles
        val editText: EditText = findViewById(R.id.edit_Number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        //Começa banco de dados
        prefes = getSharedPreferences("dataBase", Context.MODE_PRIVATE)
        val result = prefes.getString("result", null)

        //Primeira alternativa de validar
        if(result != null){
            txtResult.text = "Ultima aposta: \n $result"
        }

        //Segunda alternativa de validar
        /*
        result?.let {
            txtResult.text = "Ultima aposta: \n $result"
        }
        */

        btnGenerate.setOnClickListener {
            val text = editText.text.toString()
            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {

        //Falha
        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }


        val quantidade = text.toInt() //Converter String para Inteiro

        if (quantidade < 6 || quantidade > 15) {
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        //Sucesso
        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            //Vai gerar no maximo o numero 60
            val number = random.nextInt(60)
            numbers.add(number + 1)

            if (numbers.size == quantidade) {
                break
            }
        }
        txtResult.text = numbers.joinToString(" - ")

        //Alternativa 01
        /*
        val editor = prefes.edit()
        editor.putString("result", txtResult.text.toString())
        editor.apply()
        */

        //Alternativa 02
        prefes.edit().apply {
            putString("result", txtResult.text.toString())
            apply()
        }

        //commit -> Salvar de forma sincrona (bloquear a interface)
            // Informar se teve sucesso ou não
        //apply -> Salvar de forma assincrona (não bloqueia interface)
            // Não informa se teve sucesso ou não

    }


}