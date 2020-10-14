package com.example.milsdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agregar_cliente.*
import kotlinx.android.synthetic.main.activity_agregar_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgregarProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)

        val database2 = AppDataBase2.getDatabase2(this)
        val database = AppDatabase.getDatabase(this)

        val idCliente = intent.getIntExtra("id", 0)

        btnGuardarProducto.setOnClickListener {
            val nombreProducto = nuevoProducto.text.toString()
            val cantidad = cantidadProducto.text.toString().toInt()
            val costoImp = costoProductoImp.text.toString().toDouble()
            val costoDis = costoProductoDis.text.toString().toDouble()
            val costoTotal = costoProductoTotal.text.toString().toDouble()
            val detalle = detalleProducto.text.toString()

            val producto = Producto(nombreProducto,cantidad,costoImp,costoDis,costoTotal,detalle,idCliente)

            CoroutineScope(Dispatchers.IO).launch {
                database2.productos().insertAll(producto)

                this@AgregarProducto.finish()

            }


        }
    }
}
