package com.example.apiclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerificar = findViewById<Button>(  R.id.btnVerificar)
        val btnListado = findViewById<Button>(  R.id.btnListado)

        btnListado.setOnClickListener{
            val intento1 = Intent(this, ListadoCiudad::class.java)
            startActivity(intento1)
        }

        btnVerificar.setOnClickListener{
            if (ControlDeConexion.hayConexion(this))
            {
                Toast.makeText(this,"Estamos conectados", Toast.LENGTH_SHORT).show()

            }else
            {
                Toast.makeText(this,"Sin Conexión", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        if (ControlDeConexion.hayConexion(this))
        {
            Toast.makeText(this,"Estamos conectados",Toast.LENGTH_SHORT).show()

        }else
        {
            Toast.makeText(this,"Sin Conexión",Toast.LENGTH_SHORT).show()
        }
    }
}
