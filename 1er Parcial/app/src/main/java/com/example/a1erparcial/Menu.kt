package com.example.a1erparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnVerificar = findViewById<Button>(  R.id.btnVerificar)

        btnVerificar.setOnClickListener{
            if (ControlDeConexion.hayConexion(this))
            {
                Toast.makeText(this,"¡¡¡Hay Conexion!!!", Toast.LENGTH_SHORT).show()

            }else
            {
                Toast.makeText(this,"¡¡¡Sin Conexión!!!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
