package com.example.a1erparcial

import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import kotlinx.android.synthetic.main.activity_pais_detalle.*

class PaisDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pais_detalle)

        val pais = intent.getSerializableExtra("pais") as Pais

        val svgFlagString = MenuDeFunciones.consultarDatos(pais.flag)

        txtNombrePaisDet.text = "Pais: " + pais.nombre
        txtRegionDet.text = "Region: " + pais.region
        txtPoblacionDet.text = "Poblacion: " + pais.population.toString()
        imgBanderaDet.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        try {
            val svg: SVG = SVG.getFromString(svgFlagString)
            val drawable: Drawable = PictureDrawable(svg.renderToPicture())
            imgBanderaDet.setImageDrawable(drawable)
        } catch (e: SVGParseException) {
            Log.d("ERROR SVG", e.message)
        }

    }


}


