package com.marcos.appdefilmes.api

import com.marcos.appdefilmes.model.Categorias
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/filmes")
    fun listaCategorias(): Call<Categorias>
}