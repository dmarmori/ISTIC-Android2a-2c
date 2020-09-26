package com.example.a1erparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIngresar = findViewById<Button>(  R.id.btnIngresar)

        btnIngresar.setOnClickListener{
            val intento1 = Intent(this, Menu::class.java)
            startActivity(intento1)
        }


    }
}
