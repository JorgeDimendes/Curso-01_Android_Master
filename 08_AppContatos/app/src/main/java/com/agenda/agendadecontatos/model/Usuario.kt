package com.agenda.agendadecontatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_usuarios")
data class Usuario(
   @ColumnInfo(name = "nome") val nome: String,
   @ColumnInfo(name = "sobrenome") val sobrenome: String,
   @ColumnInfo(name = "idade") val idade: String,
   @ColumnInfo(name = "celular") val celular: String
){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
