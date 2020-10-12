package com.example.milsdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto

        productoDet.text = producto.Producto
        cantidadDet.text = producto.Cantidad.toString()
        costoImprecionDet.text = producto.CostoImpresion.toString()
        costoDiseñoDet.text = producto.CostoDiseño.toString()
        costoTotalDet.text = producto.CostoTotal.toString()

    }
}
