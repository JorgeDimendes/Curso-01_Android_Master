package com.jordev.fitnesstracker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //private lateinit var btnImc: LinearLayout
    private lateinit var rvmain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verifica se a atividade tem uma barra de ação
        val actionBar = supportActionBar
        // Oculta a barra de ação
        actionBar?.hide()

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.ic_launcher_foreground,
                textStringId = R.string.label_imc,
                color = Color.GREEN
            )
        )

        // 01) O layout XML
        // 02) A onde a recyclerview vai aparecer (tela principal, tela cheia)
        // 03) Logica - conectar o xml da celula dentro do recyclerview + quantidade de elementos dinamicos
        val adapter = MainAdapter(mainItems)
        rvmain =  findViewById(R.id.rv_mmain)
        rvmain.adapter = adapter
        rvmain.layoutManager = LinearLayoutManager(this)

    }

    private inner class MainAdapter(private val mainItems: List<MainItem>) : RecyclerView.Adapter<MainViewHolder>(){

        // 1- Qual é o layout XML da celula especifica
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // 2 - Disparada toda vez que houver uma relagem na tela e for necessario trocar o conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
        }

        // 3 - Informar quantas celular essa listagem terá
        override fun getItemCount(): Int {
            return mainItems.size
        }

    }

    // É a classe da celula em si!!!
    private class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
}