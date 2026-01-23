package com.example.proyectocasas.data

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import com.example.proyectocasas.R

data class Casa(val id:Int, val nombre:String, val imagenId:Int?, val imagenUri: Uri?, val descripcion:String)

object RepositorioCasas{

    val listaCasas = mutableStateListOf(
        Casa(1,"Casa Mediterranea", R.drawable.casa1,null,"Casa luminosa junto al mar"),
        Casa(2,"Casa Rustica", R.drawable.casa2,null,"Ambiente calido en la montana"),
        Casa(3,"Casa Moderna", R.drawable.casa3,null,"Diseno minimalista y elegante")
    )

    fun getCasaPorId(id:Int):Casa? = listaCasas.find {it.id == id}

    fun agregarCasa(casa: Casa){
        listaCasas.add(casa)
    }

    /*fun getCasaPorId(id:Int):Casa?{
        for (casa in listaCasas){
            if(casa.id==id){
                return casa
            }
        }
        return null
    }*/
}