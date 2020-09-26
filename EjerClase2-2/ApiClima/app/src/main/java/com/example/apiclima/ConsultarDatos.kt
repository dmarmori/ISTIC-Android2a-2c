package com.example.apiclima

import android.os.StrictMode
import android.util.Log
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ConsultarDatos {

    companion object{
        @Throws(IOException::class)
        fun consultarDatos(url:String):String{
            val policy= StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            var datosDescargados: InputStream?=null
            try{
                val direccionWEB= URL(url)
                val conexion=direccionWEB.openConnection() as HttpURLConnection
                conexion.requestMethod="GET"
                conexion.connect()
                datosDescargados=conexion.inputStream
                return datosDescargados.bufferedReader().use{
                    it.readText()
                }
            }catch (e: IOException)
            {
                Log.d("ciudad listado", e.message)
                // Toast.makeText(this,"${e.message}", Toast.LENGTH_SHORT).show()
            }
            finally {
                if(datosDescargados!=null)
                {
                    datosDescargados.close()
                }
            }
            return "NADA"
        }
    }
}