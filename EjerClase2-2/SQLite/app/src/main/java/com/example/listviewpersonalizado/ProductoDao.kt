package com.example.listviewpersonalizado

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hugobelman.listviewpersonalizado.Producto

//Para acceder a los datos dao(Data access objet)
@Dao
interface ProductoDao {
    @Query("SELECT * FROM productos")
    fun getAll() : LiveData<List<Producto>>

    @Insert
    fun insertAll(vararg producto: Producto)

    @Update
    fun update(producto: Producto)

    @Delete
    fun delete(producto: Producto)
}