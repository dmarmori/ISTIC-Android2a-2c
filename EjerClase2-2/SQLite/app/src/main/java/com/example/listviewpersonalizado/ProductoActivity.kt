package com.example.listviewpersonalizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugobelman.listviewpersonalizado.Producto
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto

        nombre_producto.text = producto.nombre
        precio_producto.text = "$${producto.precio}"
        detalles_producto.text = producto.descripcion



    }
}
