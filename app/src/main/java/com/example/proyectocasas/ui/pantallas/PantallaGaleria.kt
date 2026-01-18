package com.example.proyectocasas.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectocasas.data.RepositorioCasas

@Composable
fun PantallaGaleria(navController: NavController){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        item{Spacer(modifier = Modifier.height(24.dp))}

        items(RepositorioCasas.listaCasas.size){
            index: Int -> val casa=RepositorioCasas.listaCasas[index]

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { })
            {
                Row(modifier = Modifier.padding(8.dp)){

                    Image(painter = painterResource(id=casa.imagenId),
                        contentDescription = casa.nombre,
                        modifier = Modifier.size(80.dp)
                    )

                    Spacer(modifier = Modifier.padding(16.dp))

                    Column {
                        Text(casa.nombre, style = MaterialTheme.typography.titleMedium)
                        Text(casa.descripcion, maxLines = 2)
                    }
                }
            }
        }

        item{
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {navController.popBackStack()},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal=16.dp)
            ){Text("Volver al inicio")}
        }
    }
}