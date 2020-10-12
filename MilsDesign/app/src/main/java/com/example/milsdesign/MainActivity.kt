package com.example.milsdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaClientes = emptyList<Cliente>()

        val database = AppDatabase.getDatabase(this)

        database.clientes().getAll().observe(this, Observer {
            listaClientes= it

            val adapter = ClienteAdapter(this, listaClientes)

            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("nombre", listaClientes[position])
            startActivity(intent)
        }

    }
}
