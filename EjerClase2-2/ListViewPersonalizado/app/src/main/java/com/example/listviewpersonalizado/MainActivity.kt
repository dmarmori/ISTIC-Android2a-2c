package com.example.listviewpersonalizado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugobelman.listviewpersonalizado.Producto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val producto = Producto("Camara", 1200.0, "réflex SLR (Single Lens Reflex)", R.drawable.camara)
        val producto2 = Producto("PC", 2300.0, "16 GB RAM", R.drawable.pc)

        val listaProductos = listOf(producto, producto2)

        val adapter = ProductosAdapter(this, listaProductos)

        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }
    }
}
