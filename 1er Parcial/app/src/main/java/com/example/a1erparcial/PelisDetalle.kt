package com.example.a1erparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_ciudad_detalle.*
import kotlinx.android.synthetic.main.activity_pais_detalle.*
import kotlinx.android.synthetic.main.activity_pelis_detalle.*

class PelisDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelis_detalle)

        val peli = intent.getSerializableExtra("peli") as Pelis

        val urlPoster = "https://image.tmdb.org/t/p/original${peli.imagenpeli}"

        txtNombrePeliDet.text = "Nombre: " + peli.nombre
        txtLanzamiento.text = "Fecha lanzamiento: " + peli.lanzamiento
        txtLenguaje.text = "Idioma: " + peli.lenguaje
        txtPublico.text = "Cant. Espectadores: " + peli.publico.toString()
        txtPuntaje.text = "Valoracion: " + peli.puntaje.toString()
        Picasso.get().load(urlPoster).into(imgPeli)

    }
}
