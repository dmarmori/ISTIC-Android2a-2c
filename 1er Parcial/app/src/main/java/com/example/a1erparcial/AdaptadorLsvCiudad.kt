package com.example.a1erparcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdaptadorLsvCiudad (var contexto: Context, listado:ArrayList<Ciudad>) : BaseAdapter(){

    var listado:ArrayList<Ciudad>?=null
    init {
        this.listado=listado
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //  TODO("Not yet implemented")
        var holder :ViewHolder?=null
        var vista: View?=convertView
        if(vista==null)
        {
            vista= LayoutInflater.from(contexto).inflate(R.layout.datosclima,null)
            holder =ViewHolder(vista)
            vista.tag=holder
        }
        else
        {
            holder=vista.tag as? ViewHolder
        }
        val unaCiudad=getItem(position)as Ciudad


        holder?.nombre?.text=unaCiudad.nombre

        return vista!!
    }

    override fun getItem(position: Int): Any {
        //  TODO("Not yet implemented")
        return listado?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        //TODO("Not yet implemented")
        return  position.toLong()
    }

    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return listado?.count()!!// para optener el valor !!
    }
    private class ViewHolder(vista: View){
        var nombre : TextView?=null
        init {
            nombre=vista.findViewById(R.id.txtClimaCiudad)
        }
    }
}
