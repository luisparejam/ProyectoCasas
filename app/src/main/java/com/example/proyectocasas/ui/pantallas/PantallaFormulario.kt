package com.example.proyectocasas.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun PantallaFormulario(navController : NavController){

    var nombre by remember {mutableStateOf("")}

    var descripcion by remember {mutableStateOf("")}

    Column(Modifier.padding(16.dp)){

        Text("Registro de la nueva casa", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = {nuevoTexto -> nombre=nuevoTexto},
            label= {Text("Nombre de la casa")},
            isError=nombre.isBlank())

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = descripcion,
            onValueChange = {nuevaDescripcion -> descripcion=nuevaDescripcion},
            label= {Text("Descripcion de la casa")},
            isError=descripcion.length<10)

        Spacer(Modifier.height(16.dp))

        Button(onClick={
            if (nombre.isNotBlank() && descripcion.length>=10){
                navController.popBackStack()
            }
        }){Text("Guardar")}
    }
}