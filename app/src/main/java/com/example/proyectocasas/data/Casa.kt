package com.example.proyectocasas.data

import com.example.proyectocasas.R

data class Casa(val id:Int, val nombre:String, val imagenId:Int, val descripcion:String)

object RepositorioCasas{
    val listaCasas = listOf(
        Casa(1,"Casa Mediterranea", R.drawable.casa1,"Casa luminosa junto al mar"),
        Casa(2,"Casa Rustica", R.drawable.casa2,"Ambiente calido en la montana"),
        Casa(3,"Casa Moderna", R.drawable.casa3,"Diseno minimalista y elegante")
    )

    fun getCasaPorId2(id:Int):Casa? = listaCasas.find {it.id == id}

    fun getCasaPorId(id:Int):Casa?{
        for (casa in listaCasas){
            if(casa.id==id){
                return casa
            }
        }
        return null
    }
}