package com.example.milsdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agregar_cliente.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgregarCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        val database = AppDatabase.getDatabase(this)

        btnGuardarCliente.setOnClickListener {
            val nombre = nuevoCliente.text.toString()

            val cliente = Cliente(nombre, true)

            CoroutineScope(Dispatchers.IO).launch {
                database.clientes().insertAll(cliente)

                this@AgregarCliente.finish()

            }


        }
    }
}
