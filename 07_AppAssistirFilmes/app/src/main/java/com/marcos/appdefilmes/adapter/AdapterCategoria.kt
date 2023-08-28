package com.marcos.appdefilmes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcos.appdefilmes.databinding.CategoriaItemBinding
import com.marcos.appdefilmes.model.Categoria
import com.marcos.appdefilmes.model.Filme

class AdapterCategoria(private val context: Context, val listaCategorias: MutableList<Categoria>):
    RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val itemLista = CategoriaItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoriaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.titulo.text = listaCategorias[position].titulo

        val categoria = listaCategorias[position]

        holder.recyclerViewFilmes.adapter = AdapterFilme(context,categoria.filmes)
        holder.recyclerViewFilmes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun getItemCount() = listaCategorias.size

    inner class CategoriaViewHolder(binding: CategoriaItemBinding): RecyclerView.ViewHolder(binding.root) {
      val titulo = binding.txtTitulo
      val recyclerViewFilmes = binding.recyclerViewFilmes
    }
}