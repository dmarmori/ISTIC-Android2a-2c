package com.example.a1erparcial

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.StrictMode
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MenuDeFunciones {

    companion object{
        @Throws(IOException::class)
        //Consulta los datos a la URL
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
                //Toast.makeText(context,"${e.message}", Toast.LENGTH_SHORT).show()
            }
            finally {
                if(datosDescargados!=null)
                {
                    datosDescargados.close()
                }
            }
            return "NADA"
        }

        //Consulta si hay conexion a internet
        fun hayConexion(context: Context):Boolean{
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
                return getNetworkCapabilities(activeNetwork)?.run {
                    when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                } ?: false
            }
        }
    }

}