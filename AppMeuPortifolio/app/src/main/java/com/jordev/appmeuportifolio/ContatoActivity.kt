package com.jordev.appmeuportifolio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import com.jordev.appmeuportifolio.databinding.ActivityContatoBinding
import com.jordev.appmeuportifolio.databinding.ActivityMainBinding

class ContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContatoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toobarContato.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnWhats.setOnClickListener {
            abrirWhatsApp()
        }
    }

    private fun abrirWhatsApp() {
        val numeroTelefone = "5587991917477"
        val uri = Uri.parse("https://whatsapp.com/send?phone=$numeroTelefone")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        /*startActivity(intent)*/

        // Fazer verificaçã se o usuario tem o whatsApp instalado

        if (numeroTelefone.equals(numeroTelefone)){
            startActivity(intent)
        }else{
            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse
                ("https://play.google.com/store/apps/details?id=com.whatsapp"))
            startActivity(playStoreIntent)
        }
    }
}