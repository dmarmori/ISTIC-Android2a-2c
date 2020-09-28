package com.example.a1erparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ciudad_detalle.*
import kotlinx.android.synthetic.main.activity_pais_detalle.*

class CiudadDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudad_detalle)

        val clima = intent.getSerializableExtra("clima") as Ciudad

        txtNombreCiudadClimaDet.text = "Ciudad: " + clima.nombre
        txtTemDet.text = "Temperatura: " + clima.temp.toString() + "°"
        txtTermica.text = "sensacion termica: " + clima.feels_like.toString() + "°"
        txtHumedad.text = "Humedad: " + clima.humidity.toString() + "%"
        txtPresion.text = "Presion atmosferica: " + clima.pressure.toString() + "hPa"

    }
}
