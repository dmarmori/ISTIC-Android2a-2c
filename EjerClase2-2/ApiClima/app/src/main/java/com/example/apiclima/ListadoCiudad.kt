package com.example.apiclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_listado_ciudad.*
import org.json.JSONArray
import org.json.JSONObject

class ListadoCiudad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_ciudad)

        var lsvCiudad=findViewById<ListView>(R.id.LsvCiudad)

        val datos= ConsultarDatos.consultarDatos("https://api.mocki.io/v1/2cb2fa79")

        val arrayDenombreDeCiudad:  ArrayList<String> = ArrayList()
        val arrayDeobjetosDeCiudad:  ArrayList<Ciudad> = ArrayList()
        val datosJSONObject = JSONObject(datos)
        //for ( i in 0..0)
        //{
            //var ciudad= datosArrayJson.getJSONObject(i)

            Log.d("ciudad listado", datosJSONObject.getString("name"))
            arrayDenombreDeCiudad.add(datosJSONObject.getString("name"))
            arrayDeobjetosDeCiudad.add(Ciudad(datosJSONObject.getString("name"),
                                              datosJSONObject.getJSONObject("main").getInt("temp"),
                                              datosJSONObject.getJSONObject("main").getInt("humidity")))
       // }
        val adaptadorSimple = AdaptadorLvsSimple(this,arrayDeobjetosDeCiudad)
        lsvCiudad.adapter=adaptadorSimple




    }
}
