package com.example.a1erparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIngresar = findViewById<Button>(  R.id.btnIngresar)


        btnIngresar.setOnClickListener{
            try{
                if (txtUsuario.text.toString() == "prueba"  && txtClave.text.toString() == "1234")
                {
                    val intento1 = Intent(this, Menu::class.java)
                    startActivity(intento1)
                }else
                {
                    Toast.makeText(this, "ERROR DE INGRESO", Toast.LENGTH_LONG).show()

                }

            }catch (e: IOException)
            {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }



        }


    }
}
