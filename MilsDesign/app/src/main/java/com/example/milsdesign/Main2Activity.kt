package com.example.milsdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val cliente = intent.getSerializableExtra("nombre") as Cliente

        nombreClienteLista2.text = cliente.Nombre

        val producto = Producto("etiquetas",200, 10.25, 25.36, 256.33)

        val listaProducto = listOf(producto)

        val adapter = ProductoAdapter(this, listaProducto)

        lista2.adapter = adapter

        lista2.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProducto[position])
            startActivity(intent)
        }

    }
}
