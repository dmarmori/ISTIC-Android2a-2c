package com.example.milsdesign

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "clientes")
class Cliente(
    val Nombre:String,
    var Estado:Boolean,
    @PrimaryKey(autoGenerate = true)
    var idCliente: Int = 0
) : Serializable
