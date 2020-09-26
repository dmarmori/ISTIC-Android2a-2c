package com.example.apiclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_listado_ciudad.*
import org.json.JSONArray

class ListadoCiudad : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_ciudad)

        var lsvCiudad=findViewById<ListView>(R.id.LsvCiudad)

        val datos= ConsultarDatos.consultarDatos("https://api.themoviedb.org/3/movie/550?api_key=faa34d54a07231de3b8400facc8effbd")

        val arrayDenombreDeCiudad:  ArrayList<String> = ArrayList()
        val arrayDeobjetosDeCiudad:  ArrayList<Ciudad> = ArrayList()
        val datosArrayJson= JSONArray(datos);
        for ( i in 0..0)
        {
            var ciudad= datosArrayJson.getJSONObject(i)

            Log.d("ciudad listado", ciudad.getString("name"))
            arrayDenombreDeCiudad.add( ciudad.getString("name"))
            arrayDeobjetosDeCiudad.add(Ciudad( ciudad.getString("name")))
        }
        val adaptadorSimple = AdaptadorLvsSimple(this,arrayDeobjetosDeCiudad)
        lsvCiudad.adapter=adaptadorSimple




    }
}
