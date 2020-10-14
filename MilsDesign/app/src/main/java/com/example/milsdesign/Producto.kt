package com.example.milsdesign

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "productos")
class Producto (
    val Producto:String,
    val Cantidad:Int,
    val CostoImpresion:Double,
    val CostoDiseño:Double,
    val CostoTotal:Double,
    val detalle:String,
    val idCliente:Int,
    @PrimaryKey(autoGenerate = true)
    var idProducto: Int = 0
) : Serializable