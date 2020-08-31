package com.example.listviewpersonalizado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.hugobelman.listviewpersonalizado.Producto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listaProductos = emptyList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getDatabase(this)

        db.productosDao().getAll().observe(this, Observer {
            listaProductos = it
            val adapter = ProductosAdapter(this, listaProductos)

            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

        add_fab.setOnClickListener{
            val intent = Intent(this, NuevoProductoActivity::class.java)
            startActivity(intent)
        }
    }

}
